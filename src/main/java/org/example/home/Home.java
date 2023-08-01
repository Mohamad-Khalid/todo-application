package org.example.home;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping({"/{name}"})
    public String greeting(@PathVariable String name){
        return "no more restart :) "+ name;
    }
}
