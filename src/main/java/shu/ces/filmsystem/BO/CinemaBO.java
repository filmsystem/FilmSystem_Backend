package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.DAO.CinemaDAO;
import shu.ces.filmsystem.Model.Cinema;

public class CinemaBO {
    public boolean insertCinema(Cinema cinema){
        return new CinemaDAO().insertCinema(cinema);
    }

    public boolean updateCinema(Cinema cinema){
        return new CinemaDAO().updateCinema(cinema);
    }

    public boolean deleteCinema(int id){
        return new CinemaDAO().deleteCinema(id);
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
        // TODO
        //Cinema cinema = new CinemaDAO().getCinemaName();
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
