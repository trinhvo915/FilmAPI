package enclave.com.untils;

import java.util.ArrayList;
import java.util.List;

import enclave.com.dto.CommentDto;
import enclave.com.entities.Comment;
import enclave.com.entities.*;

public class ConvertComment {
	/*
	 * Convert Comment to CommnetDto
	 * 
	 */
	
	public static CommentDto CommentToCommnetDto(Comment comment){
		CommentDto commentDto = new CommentDto(comment.getId_cmt(),comment.getContent(),comment.getUser());
		return commentDto;
	}
	/*
	 * Convert CommentDto to Comment
	 * 
	 * */
	public static User getUserInList(List<User> listUser, Integer id){
		for (User user : listUser) {
			if(user.getId_user() == id){
				return user;
			}
		}
		return null;
		
	}
	
	public static Film getFilmInList(List<Film> listFilm, Integer id){
		for (Film film : listFilm) {
			if(film.getId_film()==id){
				return film;
			}
		}
		return null;	
	}
	
	
	/*
	 * Convert ListCommnet to ListCommentDto
	 * 
	 */
	public static List<CommentDto> ListCommentToListCommnet(List<Comment> listComment){
		List<CommentDto> commentDtos = new ArrayList<CommentDto>();
		for (Comment items : listComment) {
			commentDtos.add(new CommentDto(items.getId_cmt(),items.getContent(),items.getUser()));
		}
		return commentDtos;
		
	}

}
