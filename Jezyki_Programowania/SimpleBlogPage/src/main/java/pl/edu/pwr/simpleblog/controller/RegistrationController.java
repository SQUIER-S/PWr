package pl.edu.pwr.simpleblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pwr.simpleblog.model.User;
import pl.edu.pwr.simpleblog.model.UserDAO;

/**
 * Created by SQUIER on 2015-12-20.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/success")
    public String registrationCompleted(){
        return "success";
    }

    @RequestMapping(value="/register_new_user", method=RequestMethod.POST)
    public String registerNewUser(@RequestParam("login") String login,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String pass,
                                  @RequestParam("rPassword") String rpass) {

        userDAO.add(new User(login, email, pass));

        return "redirect:/success";
    }

}
