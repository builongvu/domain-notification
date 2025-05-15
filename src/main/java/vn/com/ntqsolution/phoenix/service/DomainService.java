package vn.com.ntqsolution.phoenix.service;

import org.springframework.stereotype.Service;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DomainService {

    public void sendSlackMessage(String webhookUrl, String message) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            Map<Object, Object> data = new HashMap<>();
            data.put("text", message);
            data.put("username", "Domain Notification");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(buildRequestBodyFromMap(data))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.uri());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpRequest.BodyPublisher buildRequestBodyFromMap(Map<Object, Object> data) {
        StringBuilder builder = new StringBuilder("{");
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            builder.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        builder.deleteCharAt(builder.length() - 1); // Remove the trailing comma
        builder.append("}");

        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    private Date getSSLExpiredDate(String domain) {
        try {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(domain, 443);

            sslSocket.startHandshake();

            SSLSession sslSession = sslSocket.getSession();

            Certificate[] peerCertificates = sslSession.getPeerCertificates();

            for (Certificate certificate : peerCertificates) {
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;

                    if (x509Certificate.getBasicConstraints() == -1) {
                        return x509Certificate.getNotAfter();
                    }
                }
            }

            sslSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Integer getSSLRemainingDay(Date sslExpiredDate) {
        if (sslExpiredDate == null)
            return null;

        Instant now = new Date().toInstant();
        Instant expired = sslExpiredDate.toInstant();
        Duration duration = Duration.between(now, expired);

        return (int) duration.toDays();
    }

    public String buildMessage(List<String> tkDomainList, List<String> kycDomailList, List<String> mobiusDomainList) {
        StringBuilder message = new StringBuilder();

        message.append("------------------------------ TK ------------------------------\n");

        for (String domain : tkDomainList) {
            Date sslExpiredDate = getSSLExpiredDate(domain);
            Integer sslRemainingDay = getSSLRemainingDay(sslExpiredDate);
            buildMessageByEachDomain(message, domain, sslRemainingDay);
        }

        message.append("\n\n------------------------------ KYC ------------------------------\n");

        for (String domain : kycDomailList) {
            Date sslExpiredDate = getSSLExpiredDate(domain);
            Integer sslRemainingDay = getSSLRemainingDay(sslExpiredDate);
            buildMessageByEachDomain(message, domain, sslRemainingDay);
        }

        message.append("\n\n------------------------------ MOBIUS ------------------------------\n");

        for (String domain : mobiusDomainList) {
            Date sslExpiredDate = getSSLExpiredDate(domain);
            Integer sslRemainingDay = getSSLRemainingDay(sslExpiredDate);
            buildMessageByEachDomain(message, domain, sslRemainingDay);
        }

        return String.valueOf(message);
    }

    private void buildMessageByEachDomain(StringBuilder message, String domain, Integer sslRemainingDay) {
        if (sslRemainingDay != null) {
            if (sslRemainingDay >= 0 && sslRemainingDay <= 30) {
                message.append("-* ")
                        .append(domain)
                        .append("  will expire in ")
                        .append(sslRemainingDay)
                        .append(" days.* :warning:\n");
            } else if (sslRemainingDay < 0) {
                message.append("-*")
                        .append(domain)
                        .append(" has expired.* :warning:\n");
            } else {
                message.append("- ")
                        .append(domain)
                        .append("  will expire in ")
                        .append(sslRemainingDay)
                        .append(" days.\n");
            }
        }
    }

    public void check(List<String> s) {
        for (int i = 0; i < s.size(); i++) {
            try {
                Date sslExpiredDate = getSSLExpiredDate(s.get(i));
                if (sslExpiredDate == null) {
                    System.out.println(s.get(i));
                }
            } catch (Exception ex) {
                System.out.println(s.get(i));
            }
        }
    }

}
