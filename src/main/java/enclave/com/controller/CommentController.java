package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.CommentDto;
import enclave.com.entities.Comment;
import enclave.com.service.CommentService;
import enclave.com.service.FilmService;
import enclave.com.service.UserService;
import enclave.com.utils.ConvertComment;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<CommentDto>> getAllComment(){
		List<CommentDto> listCommentDto= ConvertComment.ListCommentToListCommnet(commentService.findAllComment());
		if(listCommentDto.isEmpty()) {
			ResponseEntity<List<CommentDto>> errorListComment = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListComment;
		}
		return new ResponseEntity<>(listCommentDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="/all_idFilm/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<CommentDto>> getAllCommnetIdFilm(@PathVariable("id") Integer id){
		List<CommentDto> listCommentDto= ConvertComment.ListCommentToListCommnet(commentService.getCommentAllIdFilm(id));
		if(listCommentDto.isEmpty()) {
			ResponseEntity<List<CommentDto>> errorListComment = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListComment;
		}
		return new ResponseEntity<>(listCommentDto,HttpStatus.OK);
		
	}
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<List<CommentDto>> getCommentPage(@RequestParam(name = "id", required = false) String id,@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		      @RequestParam(name = "size", required = false, defaultValue = "10") Integer size ){	
	    Pageable pageable = PageRequest.of(page, size);
	    List<CommentDto> listCommetDtopage = ConvertComment.ListCommentToListCommnet(commentService.getCommentPage(pageable,Integer.parseInt(id)));	
	    if(listCommetDtopage.isEmpty()) {
			ResponseEntity<List<CommentDto>> errorList = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorList;
		}
		return new  ResponseEntity<>(listCommetDtopage,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/addComment1",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Comment> addComment1(@RequestBody Comment cmt){
		if(cmt != null){
			commentService.addCommnet(cmt);
			return new ResponseEntity<Comment>(cmt,HttpStatus.OK);
		}
		return new ResponseEntity<Comment>(HttpStatus.NO_CONTENT);
	}

}
