package com.assignment.rewards.controller;

import com.assignment.rewards.services.RewardService;
import com.assignment.rewards.beans.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @RequestMapping(value = "/getRewards", method = RequestMethod.GET)
    public ModelAndView getRewards(

    ){
        List<Reward> rewardList = new ArrayList<>(rewardService.getRewards());
        ModelAndView mav = new ModelAndView();
        mav.addObject("rewards", rewardList);
        mav.setViewName("show-rewards");
        return mav;
    }
}
