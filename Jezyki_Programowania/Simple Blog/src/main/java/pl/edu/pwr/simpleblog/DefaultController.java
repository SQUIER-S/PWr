package pl.edu.pwr.simpleblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SQUIER on 2015-12-04.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String init(){
        return "index";
    }

}
