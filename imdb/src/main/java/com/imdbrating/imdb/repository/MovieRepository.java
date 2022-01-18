package com.imdbrating.imdb.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.imdbrating.imdb.daos.ActorDAO;
import com.imdbrating.imdb.daos.MovieDAO;
import com.imdbrating.imdb.models.ActorDTO;

@Repository
public class MovieRepository implements ImovieRepository {
	
	List<MovieDAO> movieList = new ArrayList<>();
	
	public String addMovie(final MovieDAO movieDAO) {
		String mssg;
		if(movieList.contains(movieDAO)) {
			mssg = "Movie is already present in Database";
		}
		else {
			movieList.add(movieDAO);
			mssg = "Movie added successfully";
		}
		return mssg;
	}
	
	public String updateCompleteMovieDetails(MovieDAO movieDAO, Long movieId) {
		
		String mssg;
		
		for(MovieDAO currMovie : movieList) {
			if(currMovie.getMovieId() == movieId) {
				currMovie = movieDAO;
				mssg = "Movie details are updated";
				return mssg;
			}
		}
		
		mssg = "Movie not found hence can't be updated";
		return mssg;
	}
	
	public String updatePartialMovieDetails(MovieDAO movieDAO, Long movieId) {
			
			String mssg;
			
			for(MovieDAO currMovie : movieList) {
				if(currMovie.getMovieId() == movieId) {
					
					if(movieDAO.getName() != null)
						currMovie.setName(movieDAO.getName());
					
					if(movieDAO.getGenre() != null)
						currMovie.setGenre(movieDAO.getGenre());
					
					if(movieDAO.getYearOfRelease() != null)
						currMovie.setYearOfRelease(movieDAO.getYearOfRelease());
					
					if(movieDAO.getPrimaryLanguage() != null)
						currMovie.setPrimaryLanguage(movieDAO.getPrimaryLanguage());
					
					if(movieDAO.getActors() != null)
						currMovie.setActors(movieDAO.getActors());
					
					if(movieDAO.getRatings() != null)
						currMovie.setRatings(movieDAO.getRatings());
					
					mssg = "Movie details are updated";
					return mssg;
				}
			}
			
			mssg = "Movie not found hence can't be updated";
			return mssg;
	}
	
	public String deleteParticularMovie(final Long movieId) {
		
		String mssg;
		for(MovieDAO currMovie : movieList) {
			if(currMovie.getMovieId() == movieId) {
				movieList.remove(currMovie);
				mssg = "Deleted Successfully";
				return mssg;
			}
		}
		mssg = "Movie not found hence can't be deleted";
		return mssg;
	}
	
	public List<MovieDAO> getAllMoviesByGenre(final String genre){
		
		List<MovieDAO> ans = new ArrayList<>();
		
		for(MovieDAO currMovie : movieList) {
			if(currMovie.getGenre().equalsIgnoreCase(genre)) {
				ans.add(currMovie);
			}
		}
		return ans;
	}
	
	public List<MovieDAO> getAllMoviesByActor(final String actorName){
		
		List<MovieDAO> ans = new ArrayList<>();
		
		for(MovieDAO currMovie : movieList) {
			List<ActorDAO> currActorList = currMovie.getActors();
			for(ActorDAO currActor : currActorList) {
				if(currActor.getName() == actorName) {
					ans.add(currMovie);
				}
			}
		}
		return ans;
	}
	
	public Integer getRatingOfaMovie(final Long movieId) {
		for(MovieDAO currMovie : movieList) {
			if(currMovie.getMovieId() == movieId) {
				return currMovie.getRatings();
			}
		}
		return null;
	}
	
	public List<MovieDAO> getAllMovieRatingGreaterThanThis(final Integer rating){
		List<MovieDAO> ans = new ArrayList<>();
		
		for(MovieDAO currMovie : movieList) {
			if(currMovie.getRatings() >= rating) {
				ans.add(currMovie);
			}
		}
		return ans;
	}
	
}

	
