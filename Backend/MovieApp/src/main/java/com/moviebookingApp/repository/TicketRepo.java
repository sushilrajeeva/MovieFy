package com.moviebookingApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moviebookingApp.model.Ticket;

@Repository
@Transactional
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("select r from Ticket r where r.movie_id_fk = :movieId")
	List<Ticket> getTicketList(@Param("movieId") int movieId);
	
	@Modifying
	@Query("delete from Ticket r where r.movie_id_fk = :movieId")
	void deleteTicketData(@Param("movieId") int movieId);
	
	@Query("select r from Ticket r where r.userName = :userName")
	List<Ticket> getUserTicketList(@Param("userName") String userName);
}
