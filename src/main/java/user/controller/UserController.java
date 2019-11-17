package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import user.model.User;
import user.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/addUser")
    public ModelAndView doAddUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/user/index");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("msg","Added A User");
        return modelAndView;
    }
}
