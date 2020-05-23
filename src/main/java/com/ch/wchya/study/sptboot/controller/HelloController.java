package com.ch.wchya.study.sptboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: spt-boot
 * @description:
 * @author: 王超
 * @create: 2020-05-23 23:17
 **/
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World!") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
