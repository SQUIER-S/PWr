package pl.edu.pwr.simpleblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SQUIER on 2015-12-04.
 */
@Controller
public class SimpleBlogController {

    @RequestMapping("/")
    public String mainPage() {
        return "index";
    }

}
