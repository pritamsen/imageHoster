package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // passes the comment to be persisted in the DB
    public List<Comment> updateAComment(Comment comment,Integer imageId) {
        return commentRepository.updateAComment(comment,imageId);
    }

    // passes the list of all comment to be persisted in the DB
    public List<Comment> getListOfCommentsByImageId(Integer imageId) {
        return commentRepository.getListOfCommentsByImageId(imageId);
    }
}
