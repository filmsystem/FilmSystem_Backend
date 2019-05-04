package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.FilmComment;

public class FilmCommentController {
    public static Logger log = LoggerFactory.getLogger(FilmOfficeController.class);

    @PostMapping("/filmcomment")
    public boolean addFilmComment(@RequestParam("userId") Integer recordId,
                                  @RequestParam("filmId") Integer filmId,
                                  @RequestParam("filmStar") Integer filmStar,
                                  @RequestParam("comment") String comment){
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

    @RequestMapping(value = "/filmcomment", method = RequestMethod.GET)
    public FilmComment getFilmComment(@RequestParam Integer id){
        // find film comment by id in database
        return null;
    }

    @RequestMapping(value = "/filmcomment", method = RequestMethod.PUT)
    public boolean updateFilmComment(@RequestParam("id") String id,
                                     @RequestParam("filmStar") Integer filmStar,
                                     @RequestParam("comment") String comment){
        // update film comment by id in database
        return true;
    }

    @RequestMapping(value = "/filmcomment", method = RequestMethod.DELETE)
    public boolean deleteFilmComment(@RequestParam Integer id){
        // delete film comment by id in database
        return true;
    }
}
