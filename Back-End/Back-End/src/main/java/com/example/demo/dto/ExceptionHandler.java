package com.example.demo.dto;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



public class ExceptionHandler {

		public ExceptionHandler() {
		super();
	}
		public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
		@Override
	public String toString() {
		return "ExceptionHandler [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
		private String message;
		private LocalDateTime timeStamp;
		public ExceptionHandler(String message) {
			super();
			this.message = message;
			this.timeStamp=LocalDateTime.now();
		}
}


