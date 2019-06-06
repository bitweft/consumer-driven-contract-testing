package user_privilege_engine.pact;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactTestExecutionContext;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import user_privilege_engine.model.UserBillingInformation;
import user_privilege_engine.model.UserPrivilegeInformation;
import user_privilege_engine.service.ApiGateway;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingServicePactTest extends ConsumerPactTestMk2 {

    @Autowired
    ApiGateway apiGateway;

    @Override
    @Pact(provider = "billingService", consumer = "userPrivilegeService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("user1 has an active billing subscription")
                .uponReceiving("billing information request from UserPrivilegeService consumer")
                .path("/billing-info")
                .matchQuery("userId", "user1")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"userId\": \"user1\",\"Status\": \"active\"}")
                .toPact();
    }

    @Override
    protected String providerName() {
        return "billingService";
    }

    @Override
    protected String consumerName() {
        return "userPrivilegeService";
    }

    @Override
    protected void runTest(MockServer mockServer, PactTestExecutionContext context) {
        apiGateway.overrideBaseUrl(mockServer.getUrl());
        UserBillingInformation userBillingInformation = apiGateway.getBillingInformationForUser("user1");
        assertEquals("active", userBillingInformation.getStatus());
    }
}
