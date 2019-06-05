package billing_engine.controller;

import billing_engine.model.BillingInformation;
import billing_engine.service.BillingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BillingInformationController {

    @Autowired
    BillingInformationService billingInformationService;

    @GetMapping(path = "/billing-info", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BillingInformation getBillingInformationFor(@RequestParam(name = "userId") String userId) {
        return billingInformationService.getBillingInformationFor(userId);
    }
}
