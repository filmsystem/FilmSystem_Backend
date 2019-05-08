package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.Service.AdministratorService;
import shu.ces.filmsystem.Model.Administrator;

@RestController
@RequestMapping("/api")
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
            return new AdministratorService().insertAdministrator(administrator);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/administrator")
    public Administrator getAllAdministrator(){
        // find all administrator by id in database
        return null;
    }

    @RequestMapping(value = "/administrator/{id}", method = RequestMethod.GET)
    public Administrator getAdministrator(@PathVariable Integer id){
        // find administrator by id in database
        return new AdministratorService().findAdministratorById(id);
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.GET)
    public Administrator getAdministrator(@RequestParam String name){
        // find administrator by id in database
        return new AdministratorService().findAdministratorByName(name);
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.PUT)
    public boolean updateAdministrator(@RequestParam("id") Integer id,
                                       @RequestParam(value = "img", defaultValue = "") String img,
                                       @RequestParam("password") String password){
        AdministratorService administratorService = new AdministratorService();
        Administrator administrator = administratorService.findAdministratorById(id);
        administrator.setImg(img);
        administrator.setPassword(password);
        return administratorService.updateAdministrator(administrator);
    }

    @RequestMapping(value = "/administrator", method = RequestMethod.DELETE)
    public boolean deleteAdministrator(@RequestParam Integer id){
        return new AdministratorService().deleteAdministrator(id);
    }
}
