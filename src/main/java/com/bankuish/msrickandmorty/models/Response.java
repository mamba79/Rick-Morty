package com.bankuish.msrickandmorty.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Data

public class Response {

	@JsonProperty("info")
	private Info info;
	@JsonProperty("results")
	private List<Character> results;
}
