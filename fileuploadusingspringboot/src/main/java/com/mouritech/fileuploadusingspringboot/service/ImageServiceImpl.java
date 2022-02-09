package com.mouritech.fileuploadusingspringboot.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mouritech.fileuploadusingspringboot.entity.Image;
import com.mouritech.fileuploadusingspringboot.repository.ImageRepository;
import com.mouritech.fileuploadusingspringboot.response.ImageUploadResponse;
import com.mouritech.fileuploadusingspringboot.utility.ImageUtility;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imgRepository;

	@Override
	public ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file) throws IOException {
		imgRepository.save(Image.builder().imageName(file.getOriginalFilename())
						.imageType(file.getContentType())
						.image(ImageUtility.compressImage(file.getBytes())).build());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename()))
				;
	}

	@Override
	public Image findByImageName(String imgName) {

		final Optional<Image> dbImage =  imgRepository.findByImageName(imgName);
		
		return Image.builder()
				    .imageName(dbImage.get().getImageName())
				    .imageType(dbImage.get().getImageType())
				    .image(ImageUtility.decompressByte(dbImage.get().getImage())).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(String imgName) {
		final Optional<Image> dbImage =  imgRepository.findByImageName(imgName);
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(dbImage.get().getImageType()))
				.body(ImageUtility.decompressByte(dbImage.get().getImage()));
	}
}
