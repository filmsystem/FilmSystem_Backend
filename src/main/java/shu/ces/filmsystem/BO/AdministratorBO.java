package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.Administrator;

public class AdministratorBO {
    public boolean insertAdministrator(Administrator customer){
        // add to database
        return true;
    }

    public boolean updateAdministrator(Administrator customer){
        // add to database
        return true;
    }

    public boolean deleteAdministrator(int id){
        //delete in database
        return true;
    }

    public Administrator findAdministratorById(int id){
        // find in database
        return null;
    }

    public Administrator findAdministratorByName(String name){
        // find in database
        return null;
    }

    public int checkAdministrator(String username, String password){
        // check
        Administrator administrator = null;
        if(administrator != null){
            if(password.equals(administrator.getPassword())){
                return administrator.getId();
            }
            else{   // password error
                return 0;
            }
        }
        else{   // administrator not found
            return -1;
        }
    }
}
