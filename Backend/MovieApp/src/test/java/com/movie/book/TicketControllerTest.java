package com.movie.book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.moviebookingApp.controller.TicketController;
import com.moviebookingApp.model.Movie;
import com.moviebookingApp.model.Ticket;
import com.moviebookingApp.service.MovieService;
import com.moviebookingApp.service.TicketService;

import java.util.Arrays;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class TicketControllerTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private TicketController ticketController;

    @Test
    public void testAddTicket_Success() {
        Movie mockMovie = new Movie();
        mockMovie.setMovieId(1);
        mockMovie.setMovieName("Test Movie");
        mockMovie.setSeatsAvailable(10);
        
        Mockito.when(movieService.getMovieById(1)).thenReturn(mockMovie);
        Mockito.when(movieService.updateMovie(Mockito.any(Movie.class))).thenReturn(true);
        Mockito.when(ticketService.addTicket(Mockito.any(Ticket.class))).thenReturn(true);

        ResponseEntity<?> response = ticketController.addTicket(1, 5);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testAddTicket_Failure() {
        Movie mockMovie = new Movie();
        mockMovie.setMovieId(1);
        mockMovie.setMovieName("Test Movie");
        mockMovie.setSeatsAvailable(10);

        Mockito.when(movieService.getMovieById(1)).thenReturn(mockMovie);

        ResponseEntity<?> response = ticketController.addTicket(1, 15);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testGetAllTickets_Success() {
        Ticket mockTicket = new Ticket();
        Mockito.when(ticketService.getAllTickets()).thenReturn(Arrays.asList(mockTicket));

        ResponseEntity<?> response = ticketController.getAllTickets();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllTickets_Failure() {
        Mockito.when(ticketService.getAllTickets()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = ticketController.getAllTickets();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
