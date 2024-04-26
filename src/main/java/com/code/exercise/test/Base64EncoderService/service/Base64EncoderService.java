package com.code.exercise.test.Base64EncoderService.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class Base64EncoderService {

	private volatile boolean encodingInProgress = false;

	public boolean isEncodingInProgress() {
		return encodingInProgress;
	}

	public void startEncoding(String text) {
		encodingInProgress = true;
		// Base64 encode the text and send characters one by one with random pauses
		byte[] bytes = Base64.getEncoder().encode(text.getBytes());
		for (byte b : bytes) {
			try {
				Thread.sleep((int) (Math.random() * 4000) + 1000); // Random pause between 1 to 5 seconds
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			String encodedChar = Character.toString((char) b);
			// Send the encoded character to clients (not implemented here)
		}
		encodingInProgress = false;
	}

	public String encodeBase64Slowly(String data) throws InterruptedException {
		StringBuilder encoded = new StringBuilder();
		for (char c : data.toCharArray()) {
			String encodedChar = String.valueOf(Base64.getEncoder().encodeToString(Character.toString(c).getBytes()));
			encoded.append(encodedChar);
			Thread.sleep((long) (Math.random() * 4000) + 1000); // Random pause between 1-5 seconds
		}
		return encoded.toString();
	}
}
