package com.chat.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.model.Message;
import com.chat.repository.MessageRepository;

@Controller
public class ChatController {

	private static Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	MessageRepository repo;

	@GetMapping("/")
	public String index() {
		return "chat"; // chat.html
	}

	@MessageMapping("/send") // map client message send to destination eg. /app/send
	@SendTo("/topic/messages") // Sends the return value of a @MessageMapping method to clients subscribed to a
								// topic.
	public Message sendMessage(Message message) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = now.format(formatter);
		message.setSentOn(formattedDate);

		repo.save(message);

		logger.info("Received message from: " + message.getFrom() + " - " + message.getText());
		logger.info("Message sent on =" + message.getSentOn());
		return message;
	}
}
