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

    public BillingInformation() {
    }

    public BillingInformation(String userId, long planStartDate, long planEndDate) {
        this.userId = userId;
        this.planStartDate = planStartDate;
        this.planEndDate = planEndDate;
    }

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