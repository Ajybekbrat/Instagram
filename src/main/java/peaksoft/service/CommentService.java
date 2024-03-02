package peaksoft.service;

import peaksoft.entities.Comment;

import java.util.List;

public interface CommentService {
    void save(Long postId, Long userId, Comment comment);
    List<Comment> comments(Long id);
    String deleteById(Long id);
}
