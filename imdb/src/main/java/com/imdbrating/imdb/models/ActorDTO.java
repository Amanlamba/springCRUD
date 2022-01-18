package com.imdbrating.imdb.models;

import java.util.List;

public class ActorDTO {
	private String name;
	private Integer age;
	private List<MovieDTO> moviesList;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<MovieDTO> getMoviesList() {
		return moviesList;
	}
	public void setMoviesList(List<MovieDTO> moviesList) {
		this.moviesList = moviesList;
	}
}
