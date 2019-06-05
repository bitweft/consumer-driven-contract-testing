package billing_engine.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_information")
public class BillingInformation {
    private long planStartDate;
    private long planEndDate;
    @Id
    private String userId;

    String getUserId() {
        return userId;
    }

    long getPlanStartDate() {
        return planStartDate;
    }

    long getPlanEndDate() {
        return planEndDate;
    }
}