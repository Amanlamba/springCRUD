package com.imdbrating.imdb.models;

import java.util.List;

import com.imdbrating.imdb.enums.Language;

import lombok.Data;

@Data
public class MovieDTO {
	
	private Long movieId;
	private String name;
	private String genre;
	private DateDTO yearOfRelease;
	private Language primaryLanguage;
	private List<ActorDTO> actors;
	private Integer ratings;

	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public DateDTO getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(DateDTO yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public Language getPrimaryLanguage() {
		return primaryLanguage;
	}
	public void setPrimaryLanguage(Language primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}
	public List<ActorDTO> getActors() {
		return actors;
	}
	public void setActors(List<ActorDTO> actors) {
		this.actors = actors;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
}
