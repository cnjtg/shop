package com.cnjtg.shopserver.controllers;

import com.cnjtg.shopserver.beans.Results;
import com.cnjtg.shopserver.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-24 14:59
 */
@RestController
@RequestMapping("")
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public Results login(@RequestBody User user) {
        if ("tom".equals(user.getUsername())) {
            return Results.SUCCESS();
        }
        return Results.ERROR("账号或密码错误！");
    }
}
