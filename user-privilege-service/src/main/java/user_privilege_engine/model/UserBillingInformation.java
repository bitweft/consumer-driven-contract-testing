package user_privilege_engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserBillingInformation {
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("Status")
    private String status;

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
