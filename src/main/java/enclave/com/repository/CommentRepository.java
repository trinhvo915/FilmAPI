package enclave.com.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	@Query(value ="Select * from comment c where c.id_film = :id", nativeQuery=true)
	List<Comment> getCommentIdFilm(@Param("id") Integer id);
	
	@Query(value ="Select * from comment e where e.id_film = :id", nativeQuery=true)
	List<Comment> getCommentPage(Pageable pageable,Integer id);
	
	//boolean addCommnet();

}
