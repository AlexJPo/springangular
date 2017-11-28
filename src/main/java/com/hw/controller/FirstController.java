package com.hw.controller;

import com.hw.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/first")
public class FirstController {
    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public List<User> home() {
        List<User> model = new ArrayList<>();
        model.add(new User("test1", 15));
        model.add(new User("test2", 25));
        model.add(new User("test3", 35));
        model.add(new User("test4", 45));

        return model;
    }
}
