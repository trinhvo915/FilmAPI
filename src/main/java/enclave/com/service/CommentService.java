package enclave.com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import enclave.com.entities.Comment;

public interface CommentService {
	
	List<Comment> findAllComment();
	List<Comment> getCommentAllIdFilm(Integer id);
	List<Comment> getCommentPage(Pageable pageable,Integer id);
	boolean addCommnet(Comment comment);

}
