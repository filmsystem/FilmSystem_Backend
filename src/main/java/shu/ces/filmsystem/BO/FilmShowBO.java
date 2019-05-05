package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.FilmShow;

import java.util.ArrayList;

public class FilmShowBO {
    public boolean createShow (FilmShow show){

        StringBuffer buffer = new StringBuffer();
        int len = 999;  // ???
        for (int i = 0; i < len; i++) {
            buffer.append("0");
        }
        show.setSeat(buffer.toString());
        // add to database
        return true;
    }

    public boolean updateShow(FilmShow show){
        // update to database

        return true;
    }

    public boolean deleteShow(int id){
        // delete in database

        return true;
    }

    public FilmShow findShowById(int id){
        // find in database
        return null;
    }

    public ArrayList<FilmShow> findShowByCinemaId(int cinemaId){
        // find in database
        return null;
    }

    public ArrayList<FilmShow> findShowByFilmeId(int filmId){
        // find in database
        return null;
    }
}
