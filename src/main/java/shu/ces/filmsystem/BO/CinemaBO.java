package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.Cinema;

public class CinemaBO {
    public boolean insertCinema(Cinema customer){
        // add to database
        return true;
    }

    public boolean updateCinema(Cinema customer){
        // add to database
        return true;
    }

    public boolean deleteCinema(int id){
        //delete in database
        return true;
    }

    public Cinema findCinemaById(int id){
        // find in database
        return null;
    }

    public Cinema findCinemaByName(String name){
        // find in database
        return null;
    }

    public int checkCinema(String username, String password){
        // check
        Cinema cinema = null;
        if(cinema != null){
            if(password.equals(cinema.getPassword())){
                return cinema.getId();
            }
            else{   // password error
                return 0;
            }
        }
        else{   // cinema not found
            return -1;
        }
    }
}
