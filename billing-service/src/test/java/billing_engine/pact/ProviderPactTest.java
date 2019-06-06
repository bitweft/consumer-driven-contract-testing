package billing_engine.pact;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import billing_engine.model.BillingInformation;
import billing_engine.repository.BillingInformationRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRestPactRunner.class)
@Provider("billingService")
@PactBroker(host = "localhost", port = "9292")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProviderPactTest {
    @Autowired
    BillingInformationRepository billingInformationRepository;

    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @State("user1 has an active billing subscription")
    public void setupUser1BillingSubscription() {
        BillingInformation billingInformation = new BillingInformation("user1", 1558022930000L, 3798634130000L);
        billingInformationRepository.save(billingInformation);
    }
}
