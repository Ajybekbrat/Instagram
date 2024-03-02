package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.repositories.PostRepository;
import peaksoft.service.PostService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public void createPost(Long id, Post post) {
        String imageUrl = post.getImageUrl();
        Image image = new Image();
        image.setImageUsl(imageUrl);
       image.setPost(post);
       post.addImage(image);
        postRepository.createPost(id, post);
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public String updatePost(Long id, Post newPost) {
        return null;
    }

    @Override
    public String deletePost(Long id) {
        return postRepository.deletePost(id);
    }
}
