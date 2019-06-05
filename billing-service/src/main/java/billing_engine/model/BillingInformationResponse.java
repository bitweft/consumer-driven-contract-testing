package billing_engine.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonComponent
public class BillingInformationResponse extends JsonSerializer<BillingInformation> {

    @Override
    public void serialize(BillingInformation billingInformation, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("userId", billingInformation.getUserId());
        gen.writeStringField("planStartDate", getDisplayableDate(billingInformation.getPlanStartDate()));
        gen.writeStringField("planEndDate", getDisplayableDate(billingInformation.getPlanEndDate()));
        gen.writeStringField("Status", getStatus(billingInformation.getPlanEndDate()));
        gen.writeEndObject();
    }

    private String getStatus(long planEndDate) {
        if (new Date().getTime() <= planEndDate) {
            return "active";
        } else {
            return "inactive";
        }
    }

    private String getDisplayableDate(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
        return sdf.format(date);
    }
}
