package tech.hdurmaz.sms.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@Component
@SessionScope
@ToString
public class ClientRequestInfo {
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
}
