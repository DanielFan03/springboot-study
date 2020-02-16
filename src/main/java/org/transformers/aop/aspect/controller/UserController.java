package org.transformers.aop.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.transformers.aop.aspect.pojo.User;
import org.transformers.aop.aspect.service.UserService;
import org.transformers.aop.aspect.validator.UserValidator;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    public User printUser(Long id, String userName, String note) {
        User user = null;
        if (null != id && null != userName && null != note) {
            user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setNote(note);
        }
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/validate")
    public User validateAndPrint(Long id, String userName, String note) {
        User user = null;
        if (null != id && null != userName && null != note) {
            user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setNote(note);
        }
        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @GetMapping("/manyAspects")
    public String manyAspects() {
        userService.manyAspects();
        return "many aspects";
    }
}
