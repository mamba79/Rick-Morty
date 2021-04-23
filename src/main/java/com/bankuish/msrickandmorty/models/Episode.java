package com.bankuish.msrickandmorty.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.util.List;
@Builder
@Data
public class Episode {

	@Getter
	@JsonProperty("id")
   private int id;
	@Getter
	@JsonProperty("name")
   private String name;
	@Getter
	@JsonProperty("air_date")
	private int air_date;
	@Getter
	@JsonProperty("episode")
	private String episode;
	@Getter
	@JsonProperty("characters")
	private List<Character> characters;
	@Getter
	@JsonProperty("url")
	private String url;
	@Getter
	@JsonProperty("created")
	private String created;

}
