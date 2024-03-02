package peaksoft.repositories;

import peaksoft.entities.Post;

import java.util.List;

public interface PostRepository {
    //crud
    void createPost(Long id,Post post);
    List<Post>getAllPosts();
    Post getPostById(Long id);

    String deletePost(Long id);

}
