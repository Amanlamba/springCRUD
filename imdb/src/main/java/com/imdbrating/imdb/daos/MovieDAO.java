package com.imdbrating.imdb.daos;

import java.util.List;

import com.imdbrating.imdb.enums.Language;

public class MovieDAO {
	private Long movieId;
	private String name;
	private String genre;
	private DateDAO yearOfRelease;
	private Language primaryLanguage;
	private List<ActorDAO> actors;
	private Integer ratings = 0;

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
	public DateDAO getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(DateDAO yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public Language getPrimaryLanguage() {
		return primaryLanguage;
	}
	public void setPrimaryLanguage(Language primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}
	public List<ActorDAO> getActors() {
		return actors;
	}
	public void setActors(List<ActorDAO> actors) {
		this.actors = actors;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
}
