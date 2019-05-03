package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.model.Customer;
import org.springframework.ui.Model;

@RestController
public class CustomerController {
    public static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/customer")
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

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam Integer id){
        // find user by id in database
        return null;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public boolean getCustomer(@RequestParam("id") String id, @RequestParam("password") String password,
                                @RequestParam("gender") String gender, @RequestParam("phonenum") String phonenum){
        // update user by id in database
        return true;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@RequestParam Integer id){
        // delete user by id in database
        return true;
    }
}
