package com.imdbrating.imdb.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdbrating.imdb.daos.ActorDAO;
import com.imdbrating.imdb.daos.MovieDAO;
import com.imdbrating.imdb.models.ActorDTO;
import com.imdbrating.imdb.models.ApiResponse;
import com.imdbrating.imdb.models.MovieDTO;
import com.imdbrating.imdb.services.ImovieService;
import com.imdbrating.imdb.services.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("movie")
@Slf4j
public class MovieController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	ImovieService movieService;
	
	@PostMapping
	public ResponseEntity<ApiResponse> addMovie(@RequestBody final MovieDTO movieDTO){ // Should we get DTO here or DAO
		
		final ApiResponse response = new ApiResponse();
		
		if(movieDTO == null) {
			response.setData("Invalid Movie Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		final MovieDAO movieDAO = objectMapper.convertValue(movieDTO, MovieDAO.class);
		String mssg = movieService.addMovie(movieDAO);
		response.setData(mssg);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PutMapping(params = "movieId")
	public ResponseEntity<ApiResponse> updateCompleteMovieDetails(@RequestBody final MovieDTO movieDTO, @RequestParam(value="movieId") final Long movieId){
		
		final ApiResponse response = new ApiResponse();
		
		if(movieDTO == null) {
			response.setData("Invalid Movie Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		final MovieDAO movieDAO = objectMapper.convertValue(movieDTO, MovieDAO.class);
		String mssg = movieService.updateCompleteMovieDetails(movieDAO, movieId);
		response.setData(mssg);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PatchMapping(params = "movieId")
	public ResponseEntity<ApiResponse> updatePartialMovieDetails(@RequestBody final MovieDTO movieDTO, @RequestParam(value="movieId") final Long movieId){
		final ApiResponse response = new ApiResponse();
		
		if(movieDTO == null) {
			response.setData("Invalid Movie Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		final MovieDAO movieDAO = objectMapper.convertValue(movieDTO, MovieDAO.class);
		String mssg = movieService.updateCompleteMovieDetails(movieDAO, movieId);
		response.setData(mssg);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(params = "movieId")
	public ResponseEntity<ApiResponse> deleteParticularMovie(@RequestParam(value="movieId") final Long movieId){
		final ApiResponse response = new ApiResponse();
		
		if(movieId == null) {
			response.setData("Invalid Movie Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		String mssg = movieService.deleteParticularMovie(movieId);
		response.setData(mssg);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(params = "genre")
	public ResponseEntity<ApiResponse> getAllMoviesByGenre(@RequestParam(value="genre") final String genre){
		final ApiResponse response = new ApiResponse();
		
		if(genre == null) {
			response.setData("Invalid Genre Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		List<MovieDAO> movieByGenreDAO = movieService.getAllMoviesByGenre(genre); // What if here it return list of movie name then how can we convert DAO to DTO
		List<MovieDTO> movieByGenreDTO = new ArrayList<>();
		
		for(MovieDAO currMovie : movieByGenreDAO) {
			final MovieDTO tempMovie = objectMapper.convertValue(currMovie, MovieDTO.class);
			movieByGenreDTO.add(tempMovie);
		}
		
		if(movieByGenreDTO.size() > 0) {
			response.setData(movieByGenreDTO);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData("No movies found for this genre");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(params = "actorName")
	public ResponseEntity<ApiResponse> getAllMoviesByActor(@RequestParam(value="actorName") final String actorName){
		final ApiResponse response = new ApiResponse();
		
		if(actorName == null) {
			response.setData("Invalid Actor Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		List<MovieDAO> movieByActorDAO = movieService.getAllMoviesByActor(actorName); 
		List<MovieDTO> movieByActorDTO = new ArrayList<>();
		
		for(MovieDAO currMovie : movieByActorDAO) {
			final MovieDTO tempMovie = objectMapper.convertValue(currMovie, MovieDTO.class);
			movieByActorDTO.add(tempMovie);
		}
		
		if(movieByActorDTO.size() > 0) {
			response.setData(movieByActorDTO);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData("No movies found for this Actor");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping(params = "movieId")
	public ResponseEntity<ApiResponse> getRatingOfaMovie(@RequestParam(value="movieId") final Long movieId){
		final ApiResponse response = new ApiResponse();
		
		if(movieId == null) {
			response.setData("Invalid Movie Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		Integer rating = movieService.getRatingOfaMovie(movieId); 
		
		if(rating != null) {
			response.setData(rating);
			return new ResponseEntity<>(response, HttpStatus.OK);			
		}
		else {
			response.setData("No rating found for this movie");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping(params = "rating")
	public ResponseEntity<ApiResponse> getAllMovieRatingGreaterThanThis(@RequestParam(value="rating") final Integer rating){
		final ApiResponse response = new ApiResponse();
		
		if(rating == null) {
			response.setData("Invalid Rating Details");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		List<MovieDAO> movieByActorDAO = movieService.getAllMovieRatingGreaterThanThis(rating); 
		List<MovieDTO> movieByActorDTO = new ArrayList<>();
		
		for(MovieDAO currMovie : movieByActorDAO) {
			final MovieDTO tempMovie = objectMapper.convertValue(currMovie, MovieDTO.class);
			movieByActorDTO.add(tempMovie);
		}
		
		if(movieByActorDTO.size() > 0) {
			response.setData(movieByActorDTO);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData("No movies found greater than or equal to this Rating");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
}
