package com.consumer.beans;

public class Joke {

	private String category;
	private String type;
	private String joke;
	private String id;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Joke(String category, String type, String joke, String id) {
		super();
		this.category = category;
		this.type = type;
		this.joke = joke;
		this.id = id;
	}

}
