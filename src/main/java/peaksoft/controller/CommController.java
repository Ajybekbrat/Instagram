package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Comment;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.service.CommentService;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequestMapping("/comm")
@RequiredArgsConstructor
public class CommController {
    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    @GetMapping("/newCreateComments/{userID}/{postId}")
    public String createComment(@PathVariable("userID") Long userID, Model model,
                                @PathVariable Long postId){
        model.addAttribute("newComm" , new Comment());
        model.addAttribute("userID", userID);
        model.addAttribute("postID", postId);
        return "/comment";
    }

    @PostMapping("/saveComment/{userID}/{postID}")
    public String saveComment(@ModelAttribute("newComm") Comment comment,
                              @PathVariable("userID") Long userID,
                              @PathVariable("postID") Long postID){
        commentService.save(userID,postID,comment);
        return "/UserProfile";
    }
    @GetMapping("/allComments/{postId}")
    public String allComments(@PathVariable Long postId, Model model){
        model.addAttribute("allComments",  commentService.comments(postId));
        return "/UserProfile";

    }
}
