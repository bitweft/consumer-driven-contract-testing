package user_privilege_engine.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user_privilege_engine.model.UserPrivilegeInformation;

@Service
class ApiGateway {

    @Value("${billing-service.base-url}")
    private String baseUrl;

    UserPrivilegeInformation getBillingInformationForUser(String userId) {
        String url = baseUrl + "/billing-info?userId=" + userId;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, UserPrivilegeInformation.class);
    }
}
