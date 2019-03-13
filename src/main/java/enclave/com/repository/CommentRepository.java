package enclave.com.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Query(value = "SELECT c.* FROM comment AS c WHERE c.id_film = :id_film", nativeQuery = true)
	List<Comment> getAllCommentByIdFilm(@Param ("id_film") long id_film);
	
	
	//List Comment Pageable
	@Query(value = "SELECT * FROM comment", nativeQuery = true)
	List<Comment> getCommentPageable(Pageable pageable);
}
