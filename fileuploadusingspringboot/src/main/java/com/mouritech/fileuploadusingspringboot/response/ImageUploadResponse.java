package com.mouritech.fileuploadusingspringboot.response;

public class ImageUploadResponse {
	
	private String message;

	public ImageUploadResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
