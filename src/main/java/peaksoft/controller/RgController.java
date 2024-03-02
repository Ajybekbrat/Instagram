package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.service.UserService;
import peaksoft.service.User_InfoService;
import peaksoft.service.serviceImpl.UserServiceImpl;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class RgController {
    private final UserService userService;

    private final User_InfoService userInfoService;


    @GetMapping("/profile2")
    public String profile2() {
        return "/LogInUser";
    }


    @GetMapping("/newLogin")
    public String createLogIn(Model model) {
        model.addAttribute("newUser", new User());
        return "LogInUser";
    }

    @PostMapping("/newLogIn")
    public String createLogIn(@ModelAttribute("newUser") User user, Model model) {
        try {
            User user1 = userService.LogIn(user);

            if (user1 != null) {
                model.addAttribute("userInfo", user1);
                return "/UserProfile";
            } else {
                return "error-page";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error User name or password");
            return "error-page";
        }
    }


    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allCompanies", userService.getAllUsers());
        return "/users";


    }


    @GetMapping("/new")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user );
        return "/newUsers";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        try {
            if (user != null) {
                userService.Register(user);
                return "/LogInUser";
            } else {
                return "/error-page";
            }
        } catch (Exception e) {
            return "error-page";
        }
    }
    @GetMapping("/search/{userId}")
    public String searchUser(@RequestParam("userName") String userName, Model model, @PathVariable Long userId){
        User keyword1 = userService.getUserByName(userName);
        model.addAttribute("searchUser", keyword1 );
        model.addAttribute("userId", userId );
        return "/findProfile";
    }

    @GetMapping("/home2")
    public String home2() {
        return "/home";
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/newUsers";
    }

    @GetMapping("/newPost")
    public String createPost(Model model) {
        model.addAttribute("newPost", new Post());
        return "/newUsers";
    }




    @PostMapping("/update/{userId}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("userId") Long userId) {
        userService.updateUser(userId, user);
        return "redirect:/UserProfile";

    }
    @GetMapping("/newInfo/{userId}")
    public String createInfo(@PathVariable("userId")Long id, Model model) {
        UserInfo userInfo = userService.getUserById(id).getUserInfo();

        model.addAttribute("foundUserInfo",userInfo);
        return "/userInfo";
    }

    @PostMapping("/saveInfo/{infoId}")
    public String updateUserInfo(@ModelAttribute("foundUserInfo") UserInfo userInfo,
                               @PathVariable("infoId") Long infoId) {
        userInfoService.saveInfo(infoId, userInfo);

        return "/UserProfile";
    }

}




