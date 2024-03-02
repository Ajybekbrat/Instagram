package peaksoft.service;

import peaksoft.entities.Post;

import java.util.List;

public interface PostService {
    void createPost(Long id, Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    String updatePost(Long id, Post newPost);
    String deletePost(Long id);
}
