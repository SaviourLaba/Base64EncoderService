package com.code.exercise.test.Base64EncoderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.exercise.test.Base64EncoderService.service.Base64EncoderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Base64EncoderController {
	@Autowired
	private Base64EncoderService encoderService;

	@PostMapping("/start")
	public ResponseEntity<String> startEncoding(@RequestBody String data) throws InterruptedException {
		String encoded = encoderService.encodeBase64Slowly(data);
		return ResponseEntity.ok(encoded);
	}
}
