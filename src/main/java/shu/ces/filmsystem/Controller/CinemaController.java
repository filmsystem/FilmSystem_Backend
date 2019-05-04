package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.Cinema;

public class CinemaController {
    public static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/cinema")
    public boolean addCustomer(@RequestParam("name") String name, @RequestParam("password") String password,
                               @RequestParam("city") String city, @RequestParam("address") String address){
        // log.info("name = " + name + ", password = " + password + ", city = " + city + ", address = " + address);
        try{
            // add to database
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.GET)
    public Cinema getCinema(@RequestParam Integer id){
        // find cinema by id in database
        return null;
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.PUT)
    public boolean updateCinema(@RequestParam("id") String id, @RequestParam("password") String password,
                                @RequestParam("city") String city, @RequestParam("address") String address){
        // update cinema by id in database
        return true;
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@RequestParam Integer id){
        // delete cinema by id in database
        return true;
    }
}
