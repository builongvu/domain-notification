package vn.com.ntqsolution.phoenix;

import vn.com.ntqsolution.phoenix.service.DomainService;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {

    public static final long A_MINUTE = 60 * 1000;
    public static final long FIVE_MINUTES = 5 * A_MINUTE;
    public static final long A_SECOND = 1000L;
    public static final long AN_HOUR = 60 * A_MINUTE;
    public static final long A_DAY = 24 * AN_HOUR;

    public static void main(String[] args) throws ParseException {
        DomainService domainService = new DomainService();
        List<String> s = Arrays.asList("stg.secret--secret.com",
                "lp.stg.secret--secret.com",
                "stg.webview.secret--secret.com",
                "stg.www3.secret--secret.com",
                "secret--secret.com",
                "api-server.secret--secret.com",
                "api.secret--secret.com",
                "chat.secret--secret.com",
                "file.secret--secret.com",
                "lp.secret--secret.com",
                "sip.secret--secret.com",
                "stf.secret--secret.com",
                "webview.secret--secret.com",
                "www3.secret--secret.com",
                "secret.com",
                "api-server-secret.secret.com",
                "stf.secret.secret.com",
                "staging.lp.sukkirinn.com",
                "staging.sukkirinn.com",
                "staging.lp.webview.sukkirinn.com",
                "staging.webview.sukkirinn.com",
                "stg.webview.sukkirinn.com",
                "staging.www3.sukkirinn.com",
                "sukkirinn.com",
                "api-server.sukkirinn.com",
                "chat.sukkirinn.com",
                "lp.sukkirinn.com",
                "stf.sukkirinn.com",
                "webview.sukkirinn.com",
                "lp.webview.sukkirinn.com",
                "www3.sukkirinn.com");
        domainService.check(s);
    }

    private static boolean isNotContinuesLoginDay(Date lastLoginDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY); // Tháng bắt đầu từ 0
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 21);
        calendar.set(Calendar.SECOND, 0);

        long current = calendar.getTimeInMillis();

//        long durationLogin = System.currentTimeMillis() - roundingDate(lastLoginDate).getTime();
        long durationLogin = current - roundingDate(lastLoginDate).getTime();
        return durationLogin > A_DAY;
    }

    public static Date roundingDate(Date d) {
        if (d == null) {
            return null;
        }
        int year = d.getYear();
        int month = d.getMonth();
        int date = d.getDate();

        Date newDay = new Date(year, month, date + 1);

        return newDay;
    }

}
