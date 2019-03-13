package enclave.com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import enclave.com.entities.Comment;

public interface CommentService {

	List<Comment> getAllComment();
	
	List<Comment> listCommentByIdFilm(long id_film);

	List<Comment> listCommentPageable(Pageable pageable);
}
