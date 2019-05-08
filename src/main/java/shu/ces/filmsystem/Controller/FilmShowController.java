package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.Service.FilmShowService;
import shu.ces.filmsystem.Model.FilmShow;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
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
            FilmShow show = new FilmShow();
            show.setFilmId(filmId);
            show.setCinemaId(cinemaId);
            show.setOfficeId(officeId);
            show.setBeginTime(beginTime);
            show.setDuration(duration);
            show.setPrice(price);
            return new FilmShowService().createShow(show);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.GET)
    public FilmShow getFilmShow(@RequestParam Integer id){
        return new FilmShowService().findShowById(id);
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.PUT)
    public boolean updateFilmShow(@RequestParam("id") Integer id,
                                  @RequestParam(value = "officeId") Integer officeId,
                                  @RequestParam(value = "beginTime") Timestamp beginTime,
                                  @RequestParam(value = "seat") String seat){
        FilmShowService showBO = new FilmShowService();
        FilmShow show = showBO.findShowById(id);
        show.setOfficeId(officeId);
        show.setBeginTime(beginTime);
        show.setSeat(seat);
        return true;
    }

    @RequestMapping(value = "/filmshow", method = RequestMethod.DELETE)
    public boolean deleteFilmShow(@RequestParam Integer id){
        return new FilmShowService().deleteShow(id);
    }
}
