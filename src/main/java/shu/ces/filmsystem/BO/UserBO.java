package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.User;

public class UserBO {
    public int checkUser(String username, String password, int identity){
        /**
         * @param： username，password: user input; indntity: 1:customer, 2:cinema, 3:administrator
         * @return： 0: password error;
         *          -1: user is not exist;
         *          else: userId
         */
        User user = null;
        switch(identity){
            case 1:     // customer

                break;
            case 2:     // cinema

                break;
            case 3:     // administrator

                break;
        }
        if(user != null){
            if(password.equals(user.getPassword())){
                return user.getId();
            }
            else{   // password error
                return 0;
            }
        }
        else{   // user not found
            return -1;
        }

    }

}
