package com.ustc.clustermanagersystem.clustermanagersystem.controller;

import com.ustc.clustermanagersystem.clustermanagersystem.Result.Result;
import com.ustc.clustermanagersystem.clustermanagersystem.pojo.User;
import com.ustc.clustermanagersystem.clustermanagersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;



@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        //对html进行转义，防止xss攻击
        String username =requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        System.out.println(username+"------"+requestUser.getPassword());
        if (null == user){
            return new Result(400);
        }else{
            return new Result(200);
        }
    }
}
