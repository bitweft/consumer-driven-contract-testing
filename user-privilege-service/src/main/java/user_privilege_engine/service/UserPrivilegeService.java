package user_privilege_engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_privilege_engine.model.UserPrivilegeInformation;

@Service
public class UserPrivilegeService {

    @Autowired
    ApiGateway apiGateway;

    public UserPrivilegeInformation getUserPrivilege(String userId) {
        return apiGateway.getBillingInformationForUser(userId);
    }
}