package com.mouritech.fileuploadusingspringboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mouritech.fileuploadusingspringboot.entity.Image;
import com.mouritech.fileuploadusingspringboot.response.ImageUploadResponse;
import com.mouritech.fileuploadusingspringboot.service.ImageService;

@RestController
@CrossOrigin
public class ImageController {
	
	@Autowired
	private ImageService imgService;
	
	@PostMapping("/upload/image")
	
	public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
		
		return imgService.uploadImage(file);	
	}
	
	@GetMapping("/get/image/info/{imgname}")
	public Image getImageDetails(@PathVariable("imgname") String imgName) {
		return imgService.findByImageName(imgName);
		
	}
	
	@GetMapping("/get/image/{imgname}")
	public ResponseEntity<byte[]> getImage(@PathVariable("imgname") String imgName) {
		return imgService.getImage(imgName);
		
	}

}
