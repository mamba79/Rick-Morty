package com.bankuish.msrickandmorty.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.net.URL;
import java.util.List;


@Data
//@JsonIgnoreProperties({ "episode"})
public class Character  {

	@Getter
	@JsonProperty("id")
     private int id;
	@Getter
	@JsonProperty("name")
     private String name;
	@Getter
	@JsonProperty("status")
	private String status;
	@Getter
	@JsonProperty("species")
	private String species;
	@Getter
	@JsonProperty("type")
	private String type;
	@Getter
	@JsonProperty("gender")
	private String gender;
	@Getter
	@JsonProperty("origin")
	private Location origin;
	@Getter
	@JsonProperty("location")
	private Location location;
	@Getter
	@JsonProperty("image")
	private String image;
	@Getter
	@JsonProperty("episode")
	private List<String> episodeList;
	@Getter
	@JsonProperty("url")
	private String url;
	@Getter
	@JsonProperty("created")
	private String created;
	@Getter
	private int popularity;

}
