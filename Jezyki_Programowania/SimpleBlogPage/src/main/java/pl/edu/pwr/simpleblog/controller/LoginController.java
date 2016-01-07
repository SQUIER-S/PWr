package pl.edu.pwr.simpleblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pwr.simpleblog.model.PasswordHasher;
import pl.edu.pwr.simpleblog.model.UserDAO;

import java.security.NoSuchAlgorithmException;

/**
 * Created by SQUIER on 2015-12-20.
 */
@Controller
public class LoginController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam("uLogin") String login,
                        @RequestParam("uPass") String password) {

        String checkPass = null;
        try {
            checkPass = PasswordHasher.hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (checkPass != null) {
            if(checkPass.equals(userDAO.getUserPasswordByLogin(login))) {
                return "logedIn";
            } else {
                return "loginFailed";
            }
        } else {
            return "loginFailed";
        }

    }

}
