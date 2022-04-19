package egg.edu.spring.controllers;

import egg.edu.spring.entity.User;
import egg.edu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getUser() {
        ModelAndView mav = new ModelAndView("table");
        mav.addObject("users", userService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav=new ModelAndView("form-create");
        mav.addObject("user",new User());
        return mav;
    }
    @GetMapping("/form/{username}")
    public ModelAndView getForm(@PathVariable String username) {
        ModelAndView mav=new ModelAndView("form-update");
        mav.addObject("user",userService.getById(username));
        return mav;
    }
    @RequestMapping("/create")
    public ModelAndView create(@Valid User user, Errors errors) {
        ModelAndView mav=new ModelAndView("redirect:/users");
        if (errors.hasErrors()){
            mav.setViewName("form-create");
            return mav;

            }

        userService.create(user);
        return mav;
    }
    @RequestMapping("/update")
    public ModelAndView update(@Valid User user,Errors errors) {
        ModelAndView mav=new ModelAndView("redirect:/users");
        if (errors.hasErrors()){
            mav.setViewName("form-update");
            return mav;

        }
        userService.update(user);
        return mav;
    }
    @PostMapping("/delete/{username}")
    public ModelAndView delete(@PathVariable String username) {
        ModelAndView mav=new ModelAndView("redirect:/users");
        userService.deleteById(username);
        return mav;
    }
}
