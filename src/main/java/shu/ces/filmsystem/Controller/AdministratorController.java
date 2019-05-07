package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.AdministratorBO;
import shu.ces.filmsystem.Model.Administrator;

public class AdministratorController {
    public static Logger log = LoggerFactory.getLogger(AdministratorController.class);

    @PostMapping("/administrator")
    public boolean addAdministrator(@RequestParam("name") String name,
                                    @RequestParam(value = "img", defaultValue = "") String img,
                                    @RequestParam("password") String password){
        // log.info("name = " + name + ", password = " + password;
        try{
            Administrator administrator = new Administrator();
            administrator.setUsername(name);
            administrator.setPassword(password);
            administrator.setImg(img);
            return new AdministratorBO().insertAdministrator(administrator);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.GET)
    public Administrator getAdministrator(@RequestParam Integer id){
        // find administrator by id in database
        return null;
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.PUT)
    public boolean updateAdministrator(@RequestParam("id") Integer id,
                                       @RequestParam(value = "img", defaultValue = "") String img,
                                       @RequestParam("password") String password){
        AdministratorBO administratorBO = new AdministratorBO();
        Administrator administrator = administratorBO.findAdministratorById(id);
        administrator.setImg(img);
        administrator.setPassword(password);
        return administratorBO.updateAdministrator(administrator);
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.DELETE)
    public boolean deleteAdministrator(@RequestParam Integer id){
        return new AdministratorBO().deleteAdministrator(id);
    }
}
