package billing_engine.service;

import billing_engine.model.BillingInformation;
import billing_engine.repository.BillingInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingInformationService {
    @Autowired
    private BillingInformationRepository billingInformationRepository;

    public BillingInformation getBillingInformationFor(String userId) {
        Optional<BillingInformation> maybeBillingInformation = billingInformationRepository.findById(userId);
        return maybeBillingInformation.orElse(null);
    }
}