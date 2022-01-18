package com.imdbrating.imdb.daos;

import java.util.List;


public class DateDAO {
	private String name;
	private Integer age;
	private List<MovieDAO> moviesList;

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
	public List<MovieDAO> getMoviesList() {
		return moviesList;
	}
	public void setMoviesList(List<MovieDAO> moviesList) {
		this.moviesList = moviesList;
	}
}
