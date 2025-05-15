package vn.com.ntqsolution.phoenix.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vn.com.ntqsolution.phoenix.service.DomainService;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class DomainSchedule {

    private final DomainService domainService;

    public static final List<String> TK_DOMAIN_LIST = List.of(
            "cron-web.kyuun-kyuun.com",
            "stg.cron-web.kyuun-kyuun.com",
            "tksp.cron-web.kyuun-kyuun.com",
            "stg-backend.charincharin.net",
            "callback.kyuun-kyuun.com",
            "stg-stf.again-again.net",
            "stream-video-backend.stg.kyuun-kyuun.com",
            "backend.kyuun-kyuun.com",
            "web-chat.kyuun-kyuun.com",
            "hb-stf.kyuun-kyuun.com",
            "video.kyuun-kyuun.com"
    );

    public static final List<String> KYC_DOMAIN_LIST = List.of(
            "web-admin.kyuncall.com",
            "web-admin-server.kyuncall.com",
            "api-server.kyuncall.com",
            "socket-server.kyuncall.com",
            "api-server.frog-live.com",
            "advertisement.kyuncall.com",
            "api-server.qt-livelive.com",
            "stg.api-server.qt-livelive.com",
            "staging.web-admin.kyuncall.com",
            "staging.web-admin-server.kyuncall.com",
            "staging.advertisement.kyuncall.com",
            "staging.api-server.kyuncall.com",
            "staging.socket-server.kyuncall.com",
            "staging-new.web-admin.kyuncall.com"
            );
//    public static final List<String> KYC_DOMAIN_LIST = List.of(
//        "kyuncall.com",
//        "advertisement.kyuncall.com",
//        "staging.advertisement.kyuncall.com",
//        "agent.kyuncall.com",
//        "staging.agent.kyuncall.com",
//        "api-server.kyuncall.com",
//        "staging.api-server.kyuncall.com",
//        "staging.v2.api-server.kyuncall.com",
//        "app.kyuncall.com",
//        "staging.app.kyuncall.com",
//        "approve.kyuncall.com",
//        "staging.approve.kyuncall.com",
//        "staging.callback.kyuncall.com",
//        "cron-api.kyuncall.com",
//        "staging.cron-api.kyuncall.com",
//        "staging.v2.cron-api.kyuncall.com",
//        "game.kyuncall.com",
//        "wordpress.image.kyuncall.com",
//        "staging.wordpress.image.kyuncall.com",
//        "lp.kyuncall.com",
//        "staging.lp.kyuncall.com",
//        "media.kyuncall.com",
//        "staging.media.kyuncall.com",
//        "mng.kyuncall.com",
//        "official.kyuncall.com",
//        "staging.official.kyuncall.com",
//        "stg.privacy.kyuncall.com",
//        "reviewmode-api.kyuncall.com",
//        "staging.reviewmode-api.kyuncall.com",
//        "reviewmode-socket.kyuncall.com",
//        "staging.reviewmode-socket.kyuncall.com",
//        "socket-server.kyuncall.com",
//        "staging.socket-server.kyuncall.com",
//        "staging.v2.socket-server.kyuncall.com",
//        "staging.kyuncall.com",
//        "syokai.kyuncall.com",
//        "staging.syokai.kyuncall.com",
//        "web-admin-server.kyuncall.com",
//        "staging.web-admin-server.kyuncall.com",
//        "staging.v2.web-admin-server.kyuncall.com",
//        "web-admin.kyuncall.com",
//        "staging-new.web-admin.kyuncall.com",
//        "staging.web-admin.kyuncall.com",
//        "staging-new.v2.web-admin.kyuncall.com",
//        "staging.v2.web-admin.kyuncall.com",
//        "webchat.kyuncall.com",
//        "staging.webchat.kyuncall.com",
//        "staging.webmanage.kyuncall.com",
//        "staging.v2.webmanage.kyuncall.com",
//        "webview.kyuncall.com",
//        "staging.webview.kyuncall.com",
//        "staging.v2.webview.kyuncall.com",
//        "www3.kyuncall.com",
//        "chat-pring.com",
//        "api-server.chat-pring.com",
//        "stg.api-server.chat-pring.com",
//        "callback.chat-pring.com",
//        "staging.callback.chat-pring.com",
//        "staging.v2.callback.chat-pring.com",
//        "lp.chat-pring.com",
//        "staging.chat-pring.com",
//        "lp.staging.chat-pring.com",
//        "webview.chat-pring.com",
//        "staging.webview.chat-pring.com",
//        "staging.v2.webview.chat-pring.com",
//        "www3.chat-pring.com",
//        "staging.www3.chat-pring.com",
//        "ive-app.com",
//        "api-server.ive-app.com",
//        "stg.api-server.ive-app.com",
//        "callback.ive-app.com",
//        "staging.callback.ive-app.com",
//        "lp.ive-app.com",
//        "staging.ive-app.com",
//        "lp.staging.ive-app.com",
//        "webview.ive-app.com",
//        "staging.webview.ive-app.com",
//        "staging.v2.webview.ive-app.com",
//        "www3.ive-app.com",
//        "staging.www3.ive-app.com"
//    );
//    public static final List<String> MOBIUS_DOMAIN_LIST = List.of(
//            "web-admin.ringcall-app.com",
//            "web-admin-server.ringcall-app.com",
//            "api-server.ringcall-app.com",
//            "api-server.eden--eden.com",
//            "api-server.mirage--app.com",
//            "socket-server.ringcall-app.com",
//            "socket-server.eden--eden.com",
//            "socket-server.mirage--app.com",
//            "staging.web-admin.ringcall-app.com",
//            "staging.web-admin-server.ringcall-app.com",
//            "staging.api-server.ringcall-app.com",
//            "staging.api-server.eden--eden.com",
//            "staging.api-server.mirage--app.com",
//            "staging.socket-server.ringcall-app.com",
//            "staging.socket-server.eden--eden.com",
//            "staging.socket-server.mirage--app.com"
//    );
    public static final List<String> MOBIUS_DOMAIN_LIST = List.of(
        "api-server.eden--eden.com",
        "callback.eden--eden.com",
        "eden--eden.com",
        "lp.eden--eden.com",
        "socket-server.eden--eden.com",
        "staging.api-server.eden--eden.com",
        "staging.callback.eden--eden.com",
        "staging.eden--eden.com",
        "staging.lp.eden--eden.com",
        "staging.socket-server.eden--eden.com",
        "staging.webview.eden--eden.com",
        "staging.www3.eden--eden.com",
        "webview.eden--eden.com",
        "api-server.mirage--app.com",
        "callback.mirage--app.com",
        "lp.mirage--app.com",
        "mirage--app.com",
        "socket-server.mirage--app.com",
        "staging.api-server.mirage--app.com",
        "staging.callback.mirage--app.com",
        "staging.lp.mirage--app.com",
        "staging.mirage--app.com",
        "staging.socket-server.mirage--app.com",
        "staging.webview.mirage--app.com",
        "webview.mirage--app.com",
        "agent.ringcall-app.com",
        "api-server.ringcall-app.com",
        "approve.ringcall-app.com",
        "callback.ringcall-app.com",
        "cron-api.ringcall-app.com",
        "media.ringcall-app.com",
        "mng.ringcall-app.com",
        "reviewmode-api.ringcall-app.com",
        "reviewmode-socket.ringcall-app.com",
        "ringcall-app.com",
        "socket-server.ringcall-app.com",
        "staging.agent.ringcall-app.com",
        "staging.api-server.ringcall-app.com",
        "staging.approve.ringcall-app.com",
        "staging.callback.ringcall-app.com",
        "staging.cron-api.ringcall-app.com",
        "staging.media.ringcall-app.com",
        "staging.reviewmode-api.ringcall-app.com",
        "staging.reviewmode-socket.ringcall-app.com",
        "staging.socket-server.ringcall-app.com",
        "staging.syokai.ringcall-app.com",
        "staging.web-admin-server.ringcall-app.com",
        "staging.web-admin.ringcall-app.com",
        "staging.webmanage.ringcall-app.com",
        "staging.webview.ringcall-app.com",
        "staging.wordpress.image.ringcall-app.com",
        "syokai.ringcall-app.com",
        "web-admin-server.ringcall-app.com",
        "web-admin.ringcall-app.com",
        "webview.ringcall-app.com",
        "wordpress.image.ringcall-app.com",
        "staging.api-server.berobero-app.com",
        "staging.socket-server.berobero-app.com"
    );

    public static final String SLACK_WEBHOOK = "https://hooks.slack.com/services/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";
//    public static final String SLACK_WEBHOOK = "https://hooks.slack.com/services/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";

    @Scheduled(cron = "0 0 12 * * *")
    public void checkAndSendExpiredSSLNotification() {
        log.info("START CHECK AND SEND EXPIRIED SSL NOTIFICATION");

        String message = domainService.buildMessage(TK_DOMAIN_LIST, KYC_DOMAIN_LIST, MOBIUS_DOMAIN_LIST);
        domainService.sendSlackMessage(SLACK_WEBHOOK, message);

        log.info("FINISH CHECK AND SEND EXPIRIED SSL NOTIFICATION");
    }

}
