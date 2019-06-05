package user_privilege_engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import user_privilege_engine.model.UserBillingInformation;
import user_privilege_engine.service.UserPrivilegeService;

@Controller
public class UserPrivilegeController {

    @Autowired
    UserPrivilegeService userPrivilegeService;

    @GetMapping("/user-privilege")
    @ResponseBody
    public UserBillingInformation getUserPrivilege(@RequestParam(name = "userId") String userId) {
        return userPrivilegeService.getUserPrivilege(userId);
    }
}