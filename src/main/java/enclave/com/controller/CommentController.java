package enclave.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.CommentDTO;
import enclave.com.entities.Comment;
import enclave.com.service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("{id_film}")
	public ResponseEntity<List<CommentDTO>> listCommentByIdFilm(@PathVariable (name = "id_film") long id_film){
		List<Comment> listCmt = commentService.listCommentByIdFilm(id_film);
		
		//Convert Comment to CommentDTO
		List<CommentDTO> listCmtDTO = new ArrayList<>();
		for (Comment item: listCmt) {
			CommentDTO cmtDTO = new CommentDTO(item.getId_cmt(), item.getFilm().getName_en(), item.getUser().getUsername(), item.getContent());
			listCmtDTO.add(cmtDTO);
		}
	
		
		return new ResponseEntity<List<CommentDTO>>(listCmtDTO,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Comment>> getAllComment(){
		List<Comment> listCmt = commentService.getAllComment();
		return new ResponseEntity<List<Comment>>(listCmt,HttpStatus.OK);
	}
	
	@GetMapping("page-{page}")
	public ResponseEntity<List<CommentDTO>> getCommentPageable(@PathVariable("page") int page){
		int size = 5;
		Pageable pageable = PageRequest.of(page, size);
		
		List<Comment> listCmt = commentService.listCommentPageable(pageable);
		
		//Convert listCmt to listCmtDTO
		List<CommentDTO> listCmtDTO = new ArrayList<>();
		for (Comment item: listCmt) {
			CommentDTO cmtDTO = new CommentDTO(item.getId_cmt(), item.getFilm().getName_en(), item.getUser().getUsername(), item.getContent());
			listCmtDTO.add(cmtDTO);
		}
		return new ResponseEntity<List<CommentDTO>>(listCmtDTO, HttpStatus.OK);
		
	}
}
