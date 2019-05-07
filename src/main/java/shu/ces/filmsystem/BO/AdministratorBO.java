package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.DAO.AdministratorDAO;
import shu.ces.filmsystem.Model.Administrator;

public class AdministratorBO {
    public boolean insertAdministrator(Administrator administrator){
        return new AdministratorDAO().insertAdministrator(administrator);
    }

    public boolean updateAdministrator(Administrator administrator){
        return new AdministratorDAO().updateAdministrator(administrator);
    }

    public boolean deleteAdministrator(int id){
        return new AdministratorDAO().deleteAdministrator(id);
    }

    public Administrator findAdministratorById(int id){
        // TODO: Fix bugs.
        //return new AdministratorDAO().searchAdministrator(id);
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
