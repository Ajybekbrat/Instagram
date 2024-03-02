package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.service.PostService;
import peaksoft.service.UserService;
import peaksoft.service.User_InfoService;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/newPost/{userID}")
    public String createPost(@PathVariable("userID") Long userId,
                             Model model)  { //@RequestParam, @RequestBody
        Post post = new Post();
        model.addAttribute("newPost", post);
        model.addAttribute("userID", userId);
        return "/UserPost";
    }

    @PostMapping("/savePost/{userID}")
    public String savePost(@ModelAttribute("newPost") Post post,
                           @PathVariable("userID") Long userId,
                           Model model) throws Exception {
        User user = userService.getUserById(userId);
        model.addAttribute("postInfo", user.getPosts());
        postService.createPost(userId, post);
        return "/UserProfile";
    }
    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return "/UserProfile";
    }

}
