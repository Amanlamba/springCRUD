package com.imdbrating.imdb.services;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.imdbrating.imdb.daos.ActorDAO;
import com.imdbrating.imdb.daos.MovieDAO;
import com.imdbrating.imdb.models.ActorDTO;
import com.imdbrating.imdb.models.ApiResponse;

public interface ImovieService {
	
	public String addMovie(final MovieDAO movieDAO);
	public String updateCompleteMovieDetails(final MovieDAO movieDAO, final Long movieId);
	public String updatePartialMovieDetails(final MovieDAO movieDAO, final Long movieId);
	public String deleteParticularMovie(final Long movieId);
	public List<MovieDAO> getAllMoviesByGenre(final String genre);
	public List<MovieDAO> getAllMoviesByActor(final String actorName);
	public Integer getRatingOfaMovie(final Long movieId);
	public List<MovieDAO> getAllMovieRatingGreaterThanThis(final Integer rating);
	
}
