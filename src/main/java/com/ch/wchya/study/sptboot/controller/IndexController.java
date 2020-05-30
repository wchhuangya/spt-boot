package com.ch.wchya.study.sptboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: spt-boot
 * @description:
 * @author: 王超
 * @create: 2020-05-23 23:17
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
