package org.example.controller;


import com.sun.net.httpserver.Authenticator;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PrinterURI;
import java.net.PortUnreachableException;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {



    @Autowired
    private UserService userService;



    @PostMapping("login")
    public Result login(@RequestBody User user) {
        Result result = userService.login(user);
        System.out.println("Result = " + result);
        return result;
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }


    @PostMapping("checkUserName")
    public Result checkUserName(String username) {
        Result result = userService.checkUserName(username);
        return  result;
    }

    @PostMapping("regist")
    public Result regist(@RequestBody User user) {
        Result result = userService.regist(user);
        return result;
    }


}
