package com.jp.lesson3servlet.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspDemoController {
    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute( "msg", "gamble");
        return "index";
    }
}
