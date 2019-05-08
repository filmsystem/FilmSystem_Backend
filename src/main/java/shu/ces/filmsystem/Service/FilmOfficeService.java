package shu.ces.filmsystem.Service;

import shu.ces.filmsystem.Model.FilmOffice;

import java.util.ArrayList;

public class FilmOfficeService {
    public boolean createOffice(FilmOffice office){
        // add to database
        return true;
    }

    public boolean updateOffice(FilmOffice office){
        // update to database

        return true;
    }

    public boolean deleteOffice(int id){
        // delete in database

        return true;
    }

    public FilmOffice findOfficeById(int id){
        // find in database
        return null;
    }

    public ArrayList<FilmOffice> findOfficeByCinemaId(int cinemaId){
        // find in database
        return null;
    }

    public FilmOffice findOfficeByOfficeId(int cinemaId, int officeId){
        // find in database
        return null;
    }
}
