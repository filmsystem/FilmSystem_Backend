package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.CinemaBO;
import shu.ces.filmsystem.Model.Cinema;

public class CinemaController {
    public static Logger log = LoggerFactory.getLogger(CinemaController.class);

    @PostMapping("/cinema")
    public boolean addCustomer(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam(value = "img", defaultValue = "") String img,
                               @RequestParam("city") String city,
                               @RequestParam("address") String address){
        // log.info("name = " + name + ", password = " + password + ", city = " + city + ", address = " + address);
        try{
            Cinema cinema = new Cinema();
            cinema.setUsername(name);
            cinema.setPassword(password);
            cinema.setImg(img);
            cinema.setCity(city);
            cinema.setAddress(address);
            return new CinemaBO().insertCinema(cinema);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.GET)
    public Cinema getCinema(@RequestParam Integer id){
        return new CinemaBO().findCinemaById(id);
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.PUT)
    public boolean updateCinema(@RequestParam("id") Integer id,
                                @RequestParam("password") String password,
                                @RequestParam(value = "img", defaultValue = "") String img,
                                @RequestParam("city") String city,
                                @RequestParam("address") String address){
        CinemaBO cinemaBO = new CinemaBO();
        Cinema cinema = cinemaBO.findCinemaById(id);
        cinema.setPassword(password);
        cinema.setImg(img);
        cinema.setCity(city);
        cinema.setAddress(address);
        return cinemaBO.updateCinema(cinema);
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@RequestParam Integer id){
        return new CinemaBO().deleteCinema(id);
    }
}
