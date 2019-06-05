package user_privilege_engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserPrivilegeInformation {
    private String status;

    @JsonProperty("userId")
    private String userId;

    @JsonSetter("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    private Privilege privilege = Privilege.getInstance(status);

    public Privilege getPrivilege() {
        return privilege;
    }
}
