package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Comment;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void createPost(Long id, Post post) {
        User user = entityManager.find(User.class, id);
        post.setUser(user);
        entityManager.persist(post);

    }

    @Override
    public List<Post> getAllPosts() {

        return entityManager.createQuery("select s from Post s",Post.class).getResultList();
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }



    @Override
    public String deletePost(Long id) {
        Post post = entityManager.find(Post.class, id);
entityManager.remove(post);
        return "deleted";
    }
}
