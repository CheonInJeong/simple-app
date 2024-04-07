package com.example.simpleapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/{name}")
    public ModelAndView hello(@PathVariable(value = "name") String name) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        mav.setViewName("index");
        return mav;
    }
}
