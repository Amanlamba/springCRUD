package com.imdbrating.imdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbrating.imdb.daos.ActorDAO;
import com.imdbrating.imdb.daos.MovieDAO;
import com.imdbrating.imdb.models.ActorDTO;
import com.imdbrating.imdb.repository.ImovieRepository;
import com.imdbrating.imdb.repository.MovieRepository;

@Service
public class MovieService implements ImovieService{
	
	@Autowired
	ImovieRepository movieRepository;
	
	public String addMovie(final MovieDAO movieDAO) {
		if(movieDAO.getRatings() < 1 || movieDAO.getRatings() > 5)
			return "Rating should be in 1 to 5";
		
		return movieRepository.addMovie(movieDAO);
	}

	public String updateCompleteMovieDetails(MovieDAO movieDAO, Long movieId) {
		if(movieDAO.getRatings() < 1 || movieDAO.getRatings() > 5)
			return "Rating should be in 1 to 5";
		
		return movieRepository.updateCompleteMovieDetails(movieDAO, movieId);	
	}
	
	public String updatePartialMovieDetails(final MovieDAO movieDAO, final Long movieId) {
		if((movieDAO.getRatings() != null) && (movieDAO.getRatings() < 1 || movieDAO.getRatings() > 5))
			return "Rating should be in 1 to 5";
		
		return movieRepository.updatePartialMovieDetails(movieDAO, movieId);
	}
	
	public String deleteParticularMovie(final Long movieId) {
		return movieRepository.deleteParticularMovie(movieId);
	}
	
	public List<MovieDAO> getAllMoviesByGenre(final String genre){
		return movieRepository.getAllMoviesByGenre(genre);
	}
	
	public List<MovieDAO> getAllMoviesByActor(final String actorName){
		return movieRepository.getAllMoviesByActor(actorName);
	}
	
	public Integer getRatingOfaMovie(final Long movieId) {
		return movieRepository.getRatingOfaMovie(movieId);
	}
	
	public List<MovieDAO> getAllMovieRatingGreaterThanThis(final Integer rating){
		return movieRepository.getAllMovieRatingGreaterThanThis(rating);
	}
	
}