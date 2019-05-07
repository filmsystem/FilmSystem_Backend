package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.BO.FilmOfficeBO;
import shu.ces.filmsystem.Model.FilmOffice;

@RestController
@RequestMapping("/api")
public class FilmOfficeController {
    public static Logger log = LoggerFactory.getLogger(FilmOfficeController.class);

    @PostMapping("/filmoffice")
    public boolean addFilmOffice(@RequestParam("cinemaId") Integer cinemaId,
                                 @RequestParam("officeId") Integer officeId,
                                 @RequestParam("row") Integer row,
                                 @RequestParam("col") Integer col){
        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
        try{
            FilmOffice office = new FilmOffice();
            office.setCinemaId(cinemaId);
            office.setOfficeId(officeId);
            office.setRow(row);
            office.setCol(col);
            return new FilmOfficeBO().createOffice(office);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/filmoffice", method = RequestMethod.GET)
    public FilmOffice getFilmOffice(@RequestParam Integer id){
        return new FilmOfficeBO().findOfficeById(id);
    }

    @RequestMapping(value = "/filmoffice", method = RequestMethod.PUT)
    public boolean updateFilmOffice(@RequestParam("id") Integer id,
                                    @RequestParam("row") Integer row,
                                    @RequestParam("col") Integer col){
        FilmOfficeBO officeBO = new FilmOfficeBO();
        if(officeBO == null){
            return false;
        }
        FilmOffice office = officeBO.findOfficeById(id);
        office.setRow(row);
        office.setCol(col);
        return officeBO.updateOffice(office);
    }

    @RequestMapping(value = "/filmoffice", method = RequestMethod.DELETE)
    public boolean deleteFilmOffice(@RequestParam Integer id){
        return new FilmOfficeBO().deleteOffice(id);
    }
}
