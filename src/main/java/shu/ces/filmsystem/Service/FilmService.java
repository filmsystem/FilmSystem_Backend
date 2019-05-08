package shu.ces.filmsystem.Service;

import shu.ces.filmsystem.Model.Film;

import java.util.ArrayList;

public class FilmService {
    public boolean insertFilm(Film film){
        // insert into database
        film.setStar(0);
        return true;
    }

    public boolean updateFilm(Film film){
        // update film
        return true;
    }

    public boolean deleteFilm(int id){
        //delete film
        return true;
    }

    public Film findFilmById(int id){
        // find in database
        return null;
    }

    public ArrayList<Film> findFilmByName(String name){
        // find in database
        return null;
    }

    public ArrayList<Film> findFilmByCast(String cast){
        // find in database
        return null;
    }

    public ArrayList<Film> findFilmByDirector(String director){
        // find in database
        return null;
    }
}
