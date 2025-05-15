package vn.com.ntqsolution.phoenix;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.com.ntqsolution.phoenix.job.DomainSchedule;
import vn.com.ntqsolution.phoenix.service.DomainService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@EnableScheduling
@AllArgsConstructor
@SpringBootApplication
public class PhoenixDomainNotificationApplication {

	public static final String SLACK_WEBHOOK = "https://hooks.slack.com/services/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";
	private final DomainSchedule domainSchedule;


	public static void main(String[] args) {
		SpringApplication.run(PhoenixDomainNotificationApplication.class, args);
//		DomainService domainService = new DomainService();
//		List<String> s = Arrays.asList("staging.api-server.ringcall-app.com",
//				"staging.approve.ringcall-app.com",
//		"staging.bootadmin.ringcall-app.com",
//				"staging.callback.ringcall-app.com",
//				"staging.cron-api.ringcall-app.com",
//				"staging.wordpress.image.ringcall-app.com",
//				"staging.media.ringcall-app.com",
//				"staging.official.ringcall-app.com",
//				"staging.rabbitmq-management.ringcall-app.com",
//				"staging.reviewmode-api.ringcall-app.com",
//				"staging.reviewmode-socket.ringcall-app.com",
//				"staging.socket-server.ringcall-app.com",
//				"staging.syokai.ringcall-app.com",
//				"staging.web-admin-server.ringcall-app.com",
//				"staging.web-admin.ringcall-app.com",
//				"staging.webmanage.ringcall-app.com",
//				"staging.webview.ringcall-app.com");
//		domainService.check(s);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		SlackUtil.sendSlackMessage(SLACK_WEBHOOK, "Mobius Server", "Domain service restart");
//	}

	// @PostConstruct
	// private void notifySlack() {
	// 	SlackUtil.sendSlackMessage(SLACK_WEBHOOK, "Mobius Server", "Domain service restart");
	// 	domainSchedule.checkAndSendExpiredSSLNotification();
	// }

}
