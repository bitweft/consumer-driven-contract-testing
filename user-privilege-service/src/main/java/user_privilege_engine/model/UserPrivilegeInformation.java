package user_privilege_engine.model;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserPrivilegeInformation {
    private String userId;
    private Privilege privilege;

    public UserPrivilegeInformation() {
    }

    private UserPrivilegeInformation(String userId, Privilege privilege) {
        this.userId = userId;
        this.privilege = privilege;
    }

    public static UserPrivilegeInformation getUserPrivilegeInformationFrom(String userId, UserBillingInformation userBillingInfo) {
        Privilege privilege = Privilege.getInstance(userBillingInfo.getStatus());

        return new UserPrivilegeInformation(userId, privilege);
    }

    public String getUserId() {
        return userId;
    }

    public Privilege getPrivilege() {
        return privilege;
    }
}
