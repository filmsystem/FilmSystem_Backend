package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.Service.CustomerService;
import shu.ces.filmsystem.Model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
    public static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/customer")
    public boolean insertCustomer(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam(value = "img", defaultValue = "") String img,
                               @RequestParam("gender") String gender,
                               @RequestParam("phonenum") String phonenum){
        // log.info("name = " + name + ", password = " + password + ", gender = " + gender + ", phonenum = " + phonenum);
        try{
            Customer customer = new Customer();
            customer.setUsername(name);
            customer.setPassword(password);
            customer.setImg(img);
            customer.setGender(gender);
            customer.setPhoneNum(phonenum);
            return new CustomerService().insertCustomer(customer);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam Integer id){
        return new CustomerService().findCustomerById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public boolean updateCustomer(@RequestParam("id") Integer id,
                                  @RequestParam("password") String password,
                                  @RequestParam(value = "img", defaultValue = "") String img,
                                  @RequestParam("gender") String gender,
                                  @RequestParam("phonenum") String phonenum){
        CustomerService customerBO = new CustomerService();
        Customer customer = customerBO.findCustomerById(id);
        customer.setPassword(password);
        customer.setImg(img);
        customer.setGender(gender);
        customer.setPhoneNum(phonenum);
        return customerBO.updateCustomer(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@RequestParam Integer id){
        return new CustomerService().deleteCustomer(id);
    }
}
