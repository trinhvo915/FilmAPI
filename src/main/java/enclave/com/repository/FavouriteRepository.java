package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import enclave.com.entities.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long>{
	
	@Transactional
	@Modifying	
	@Query(nativeQuery=true,value="DELETE FROM favourite WHERE id_user = :id_user AND id_film = :id_film")
	void deleteFilmFavourite(@Param("id_user") Integer id_user,@Param("id_film") Integer id_film );
}
