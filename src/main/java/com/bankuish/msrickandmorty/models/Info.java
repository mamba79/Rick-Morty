package com.bankuish.msrickandmorty.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Data

public class Info {

	@JsonProperty("count")
	private int count;
	@JsonProperty("pages")
	private int pages;
	@JsonProperty("next")
	private String next;
	@JsonProperty("prev")
	private String prev;
}
