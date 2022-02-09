package com.mouritech.fileuploadusingspringboot.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.mouritech.fileuploadusingspringboot.entity.Image;
import com.mouritech.fileuploadusingspringboot.response.ImageUploadResponse;

public interface ImageService {

	ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file) throws IOException;

	 Image findByImageName(String imgName);

	ResponseEntity<byte[]> getImage(String imgName);
	
	

}
