package peaksoft.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.FollowersService;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/followers")
@RequiredArgsConstructor
public class FollowController {
    private final FollowersService followerService;
    private final UserService userService;
    @GetMapping("/follow/{currentUserId}/{foundUserId}")
    public String follower(Model model,@PathVariable Long currentUserId,@PathVariable Long foundUserId){
        model.addAttribute("currenUserId",currentUserId);
        model.addAttribute("foundUserId",foundUserId);

        followerService.following(currentUserId,foundUserId);

        model.addAttribute("subscribers",followerService.subscribers(userService.getUserById(currentUserId).getFollower().getId()));
//        model.addAttribute("subscriptions",followerService.subscriptions(userService.finById(foundUserId).getFollower().getId()));
        return "/findProfile";
    }
    }


