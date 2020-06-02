package com.ch.wchya.study.sptboot.controller;

import com.ch.wchya.study.sptboot.dao.User;
import com.ch.wchya.study.sptboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: spt-boot
 * @description:
 * @author: 王超
 * @create: 2020-05-23 23:17
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                String token = cookie.getValue();
                User user = userMapper.getUserByToken(token);
                if (user != null)
                    request.getSession().setAttribute("user", user);
                break;
            }
        }
        return "index";
    }
}
