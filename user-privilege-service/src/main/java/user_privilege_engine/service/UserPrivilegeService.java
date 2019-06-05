package user_privilege_engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_privilege_engine.model.UserBillingInformation;

@Service
public class UserPrivilegeService {

    @Autowired
    ApiGateway apiGateway;

    public UserBillingInformation getUserPrivilege(String userId) {
        return apiGateway.getUserBillingInformationFor(userId);
    }
}