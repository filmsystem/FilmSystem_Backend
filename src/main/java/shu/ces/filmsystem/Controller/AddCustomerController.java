package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCustomerController {
    public static Logger log = LoggerFactory.getLogger(AddCustomerController.class);

    @PostMapping("/addCustomer")
    public boolean addCustomer(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("gender") String gender, @RequestParam("phonenum") String phonenum){
        // log.info("username = " + username + ", password = " + password + ", gender = " + gender + ", phonenum = " + phonenum);
        try{
            // add to database
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
