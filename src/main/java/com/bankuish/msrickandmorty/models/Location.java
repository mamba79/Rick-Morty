package com.bankuish.msrickandmorty.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Data

public class Location {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private String type;
	@JsonProperty("dimension")
	private String dimension;
	@JsonProperty("residents")
	private List<Character> residents;
	@JsonProperty("url")
	private String url;
	@JsonProperty("created")
	private String created;
}
