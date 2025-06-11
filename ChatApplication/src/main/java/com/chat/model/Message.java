package com.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long messageId;

	@Column(name = "`from`") // the backticks
	private String from;

	@Column(name = "content")
	@JsonProperty("content")
	private String text;

	@Column(name = "SENT_ON")
	private String sentOn;
}
