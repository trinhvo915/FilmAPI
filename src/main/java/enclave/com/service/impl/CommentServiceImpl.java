package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import enclave.com.entities.Comment;
import enclave.com.repository.CommentRepository;
import enclave.com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> listCommentByIdFilm(long id_film) {
		List<Comment> listCommentByIdFilm = commentRepository.getAllCommentByIdFilm(id_film);
		return listCommentByIdFilm;
	}

	@Override
	public List<Comment> getAllComment() {
		List<Comment> listAll = commentRepository.findAll();
		return listAll;
	}

	//List comment pageable
	@Override
	public List<Comment> listCommentPageable(Pageable pageable) {
		return commentRepository.getCommentPageable(pageable);
	}

}
