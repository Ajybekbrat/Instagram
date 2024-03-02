package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Comment;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final EntityManager entityManager;
    @Override
    public void save(Long postId, Long userId, Comment comment) {
//        entityManager.getTransaction().begin();
//        User user = entityManager.find(User.class, userId);
//        Post post = entityManager.find(Post.class, postId);
//        user.addComment(comment);
//        post.addComment(comment);
//        comment.setPosts(post);
//        List<User>users = new ArrayList<>();
//        users.add(user);
//        comment.setUsers(users);
//        entityManager.persist(comment);
//       entityManager.getTransaction().commit();

entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        Post post = entityManager.find(Post.class, postId);
      //  comment.getUsers().add(user);
        user.addComment(comment);
        post.addComment(comment);
        comment.setPosts(post);

        entityManager.persist(comment);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Comment> comments(Long id) {
        Post post = entityManager.find(Post.class, id);

        return post.getComment();

    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}
