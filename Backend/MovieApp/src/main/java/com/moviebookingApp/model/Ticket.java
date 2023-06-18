package com.moviebookingApp.model;

import java.util.Objects;

import javax.persistence.Column;
//import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Ticket")
public class Ticket {

	@Id
	@Column(name = "transactionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column
	private int movie_id_fk;

	@Column(name = "movieName")
	private String movieName;

	@Column(name = "totalSeat")
	private int totalSeat;

	@Column(name = "seatsAvailable")
	private int seatsAvailable;

	@Column(name = "seatsBooked")
	private int seatsBooked;
	
	@Column(name = "userName")
	private String userName;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getMovie_id_fk() {
		return movie_id_fk;
	}

	public void setMovie_id_fk(int movie_id_fk) {
		this.movie_id_fk = movie_id_fk;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieName, movie_id_fk, seatsAvailable, seatsBooked, totalSeat, transactionId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(movieName, other.movieName) && movie_id_fk == other.movie_id_fk
				&& seatsAvailable == other.seatsAvailable && seatsBooked == other.seatsBooked
				&& totalSeat == other.totalSeat && transactionId == other.transactionId
				&& Objects.equals(userName, other.userName);
	}

	public Ticket(int transactionId, int movie_id_fk, String movieName, int totalSeat, int seatsAvailable,
			int seatsBooked, String userName) {
		super();
		this.transactionId = transactionId;
		this.movie_id_fk = movie_id_fk;
		this.movieName = movieName;
		this.totalSeat = totalSeat;
		this.seatsAvailable = seatsAvailable;
		this.seatsBooked = seatsBooked;
		this.userName = userName;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
