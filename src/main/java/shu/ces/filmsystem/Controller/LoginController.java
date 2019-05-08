package shu.ces.filmsystem.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shu.ces.filmsystem.Service.AdministratorService;
import shu.ces.filmsystem.Service.CinemaService;
import shu.ces.filmsystem.Service.CustomerService;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
    public int checkUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("identity") Integer identity){
        /**
         * @param： username，password: user input; indntity: 1:customer, 2:cinema, 3:administrator
         * @return： 0: password error;
         *          -1: user is not exist;
         *          else: userId
         */
        switch(identity){
            case 1:     // customer
                return new CustomerService().checkCustomer(username, password);
            case 2:     // cinema
                return new CinemaService().checkCinema(username, password);
            case 3:     // administrator
                return new AdministratorService().checkAdministrator(username, password);
        }
        return -1;
    }
}
