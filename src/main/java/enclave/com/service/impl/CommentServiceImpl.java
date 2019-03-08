package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import enclave.com.entities.Comment;
import enclave.com.repository.CommentRepository;
import enclave.com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> findAllComment() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> getCommentAllIdFilm(Integer id) {
		return commentRepository.getCommentIdFilm(id);
	}

	@Override
	public List<Comment> getCommentPage(Pageable pageable,Integer id) {
		return commentRepository.getCommentPage(pageable,id);
	}

	@Override
	public boolean addCommnet(Comment comment) {
		Comment cmt = commentRepository.save(comment);
		if(cmt != null){
			return true;
		}
		return false;
	}
	

	
	

}
