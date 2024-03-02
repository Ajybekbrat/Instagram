package peaksoft.repositories;

import peaksoft.entities.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Long postId, Long userId,Comment comment);
    List<Comment>comments(Long id);
    String deleteById(Long id);
}
