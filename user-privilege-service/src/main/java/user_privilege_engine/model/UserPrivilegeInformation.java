package user_privilege_engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserPrivilegeInformation {
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("Status")
    private String status;

    private Privilege privilege = Privilege.getInstance(status);

    public Privilege getPrivilege() {
        return privilege;
    }

    public String getStatus() {
        return status;
    }
}
