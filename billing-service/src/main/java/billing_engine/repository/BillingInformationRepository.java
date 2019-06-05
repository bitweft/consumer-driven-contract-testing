package billing_engine.repository;

import billing_engine.model.BillingInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInformationRepository extends CrudRepository<BillingInformation, String> {
}