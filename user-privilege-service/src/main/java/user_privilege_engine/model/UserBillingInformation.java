package user_privilege_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBillingInformation {
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("Status")
    private String status;
}
