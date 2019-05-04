package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.FilmOffice;

public class FilmOfficeController {
    public static Logger log = LoggerFactory.getLogger(FilmOfficeController.class);

    @PostMapping("/filmoffice")
    public boolean addFilmOffice(@RequestParam("cinemaId") Integer cinemaId,
                                 @RequestParam("officeId") Integer officeId,
                                 @RequestParam("row") Integer row,
                                 @RequestParam("col") Integer col){
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

    @RequestMapping(value = "/filmoffice", method = RequestMethod.GET)
    public FilmOffice getFilmOffice(@RequestParam Integer id){
        // find film office by id in database
        return null;
    }

    @RequestMapping(value = "/filmoffice", method = RequestMethod.PUT)
    public boolean updateFilmOffice(@RequestParam("id") String id,
                                    @RequestParam("row") Integer row,
                                    @RequestParam("col") Integer col){
        // update film office by id in database
        return true;
    }

    @RequestMapping(value = "/filmoffice", method = RequestMethod.DELETE)
    public boolean deleteFilmOffice(@RequestParam Integer id){
        // delete film office by id in database
        return true;
    }
}
