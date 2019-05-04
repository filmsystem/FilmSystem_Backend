package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.FilmShow;

import java.sql.Timestamp;

public class FilmShowController {
    public static Logger log = LoggerFactory.getLogger(FilmShowController.class);

    @PostMapping("/filmshow")
    public boolean addFilmShow(@RequestParam("filmId") Integer filmId,
                               @RequestParam("cinemaId") Integer cinemaId,
                               @RequestParam("officeId") Integer officeId,
                               @RequestParam("beginTime") Timestamp beginTime,
                               @RequestParam("duration") Integer duration,
                               @RequestParam("price") double price){
        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
        try{
            // add to database
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.GET)
    public FilmShow getFilmShow(@RequestParam Integer id){
        // find film show by id in database
        return null;
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.PUT)
    public boolean updateFilmShow(@RequestParam("id") Integer id,
                                  @RequestParam("officeId") Integer officeId,
                                  @RequestParam("beginTime") Timestamp beginTime,
                                  @RequestParam("seat") String seat){
        // update film show by id in database
        return true;
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.DELETE)
    public boolean deleteFilmShow(@RequestParam Integer id){
        // delete film show by id in database
        return true;
    }
}
