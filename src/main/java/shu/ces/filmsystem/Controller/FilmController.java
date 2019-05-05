package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.FilmBO;
import shu.ces.filmsystem.Model.Film;
import shu.ces.filmsystem.Tools.ListToString;

import java.util.Collection;

public class FilmController {
    public static Logger log = LoggerFactory.getLogger(FilmController.class);

    @PostMapping("/film")
    public boolean addFilm(@RequestParam("name") String name,
                           @RequestParam(value = "img" , defaultValue = "") String img,
                           @RequestParam("dircetor") Collection<String> directors,
                           @RequestParam("casts") Collection<String> casts,
                           @RequestParam("type") Collection<String> type,
                           @RequestParam("year") Integer year,
                           @RequestParam("countries") Collection<String> countries,
                           @RequestParam("summary") String summary){
        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
        try{
            Film film = new Film();
            film.setName(name);
            film.setImg(img);
            film.setDirectors(ListToString.collectionToString(directors, ", "));
            film.setCasts(ListToString.collectionToString(casts, ", "));
            film.setType(ListToString.collectionToString(type, ", "));
            film.setYear(year);
            film.setCountries(ListToString.collectionToString(countries, ", "));
            film.setSummary(summary);
            return new FilmBO().insertFilm(film);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public Film getFilm(@RequestParam Integer id){
        return new FilmBO().findFilmById(id);
    }

    @RequestMapping(value = "/film", method = RequestMethod.PUT)
    public boolean updateFilm(@RequestParam("id") Integer id,
                              @RequestParam(value = "img", defaultValue = "") String img){
        FilmBO filmBO = new FilmBO();
        Film film = filmBO.findFilmById(id);
        if(film == null){
            return false;
        }
        film.setImg(img);
        return true;
    }

    @RequestMapping(value = "/film", method = RequestMethod.DELETE)
    public boolean deleteFilm(@RequestParam Integer id){
        return new FilmBO().deleteFilm(id);
    }
}
