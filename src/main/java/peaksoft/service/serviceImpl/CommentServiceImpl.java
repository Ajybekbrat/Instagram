package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Comment;
import peaksoft.repositories.CommentRepository;
import peaksoft.service.CommentService;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    @Override
    public void save(Long postId, Long userId, Comment comment) {
        commentRepository.save(postId, userId , comment);
    }

    @Override
    public List<Comment> comments(Long id) {
        return commentRepository.comments(id);
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}
