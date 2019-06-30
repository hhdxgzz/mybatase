package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Mr_Zhao
 * @Description:
 * @Date: Create in  2019/6/17 9:34
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("/user/login")
    public String login(User user, HttpSession session, Model model) {
        User loginUser = userService.findUser(user);
        if (null == loginUser) {
            model.addAttribute("msg", "账号或密码错误,请重新登陆!");
            return "forward:/index";
        }
        session.setAttribute("loginUser", loginUser);
        return "redirect:/index";
    }

    @RequestMapping(value = "/user/findAllUserAjax")
    @ResponseBody
    public List<User> findAllUserAjax() {
        return userService.findAll();
    }
}
