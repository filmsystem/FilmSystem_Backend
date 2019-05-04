package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.Film;

import java.util.Collection;

public class FilmController {
    public static Logger log = LoggerFactory.getLogger(FilmController.class);

    @PostMapping("/film")
    public boolean addFilm(@RequestParam("name") String name,
                           @RequestParam(value = "img" , defaultValue = "") String img,
                           @RequestParam("dircetor") Collection<String> director,
                           @RequestParam("casts") Collection<String> casts,
                           @RequestParam("type") Collection<String> type,
                           @RequestParam("year") Integer year,
                           @RequestParam("countries") Collection<String> countries,
                           @RequestParam("summary") String summary){
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

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public Film getFilm(@RequestParam Integer id){
        // find film by id in database
        return null;
    }

    @RequestMapping(value = "/cinema", method = RequestMethod.PUT)
    public boolean updateFilm(@RequestParam("id") String id,
                              @RequestParam(value = "img", defaultValue = "") String url){
        // update cinema by id in database
        return true;
    }

    @RequestMapping(value = "/film", method = RequestMethod.DELETE)
    public boolean deleteFilm(@RequestParam Integer id){
        // delete film by id in database
        return true;
    }
}
