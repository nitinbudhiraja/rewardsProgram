package com.assignment.rewards.controller;

import com.assignment.rewards.domain.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getMessage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("transaction", new Transaction());
        mav.setViewName("add-transaction");
        return mav;
    }
}
