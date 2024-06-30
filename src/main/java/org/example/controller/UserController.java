package org.example.controller;


import com.sun.net.httpserver.Authenticator;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
