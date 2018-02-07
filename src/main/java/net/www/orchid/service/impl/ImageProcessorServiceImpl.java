package net.www.orchid.service.impl;

import static net.www.orchid.Constants.UIImageType.PRODUCT;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.Constants.UIImageType;
import net.www.orchid.annotation.EnableUploadImageTempStorage;
import net.www.orchid.component.ImageFormatConverter;
import net.www.orchid.component.ImageOptimizator;
import net.www.orchid.component.ImageResizer;
import net.www.orchid.component.impl.UploadImageTempStorage;
import net.www.orchid.exception.CantCompleteClientRequestException;
import net.www.orchid.model.UploadResult;
import net.www.orchid.model.UploadTempPath;
import net.www.orchid.service.ImageProcessorService;
import net.www.orchid.service.ImageStorageService;

@Service
public class ImageProcessorServiceImpl implements ImageProcessorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageProcessorServiceImpl.class);
	
	@Autowired
	@Qualifier("pngToJpegImageFormatConverter")
	private ImageFormatConverter pngToJpegImageFormatConverter;
	
	@Autowired
	private ImageResizer imageResizer;
	
	@Autowired
	private ImageOptimizator imageOptimizator;
	
	@Autowired
	private ImageStorageService imageStorageService;
	
	@Autowired
	private UploadImageTempStorage uploadImageTempStorage;
	
	@Override
	@EnableUploadImageTempStorage
	public UploadResult processNewProductPhoto(MultipartFile upload) {
		try {
			return processUploadProduct(upload, PRODUCT);
		} catch (IOException e) {
			throw new CantCompleteClientRequestException("Can't save product photo upload: " + e.getMessage(), e);
		}
	}
	
	protected UploadResult processUploadProduct(MultipartFile multipartFile, UIImageType imageType) throws IOException {
		String largePhoto = generateNewFileName();
		UploadTempPath uploadTempPath = getCurrentUploadTempPath();
		transferUploadToFile(multipartFile, uploadTempPath.getLargeImagePath());
		resizeAndOptimizeUpload(uploadTempPath, imageType);
		String largePhotoLink = imageStorageService.saveAndReturnImageLink(largePhoto, imageType
								, uploadTempPath.getLargeImagePath());
		return new UploadResult(largePhotoLink);
	}
	
	protected void resizeAndOptimizeUpload(UploadTempPath uploadTempPath, UIImageType imageType) throws IOException {
		imageResizer.resizeImage(uploadTempPath.getLargeImagePath()
								, uploadTempPath.getLargeImagePath()
								, imageType.getLargeWidth()
								, imageType.getLargeHeight());
		imageOptimizator.optimize(uploadTempPath.getLargeImagePath());
	}

	protected String generateNewFileName() {
		return UUID.randomUUID().toString() + ".jpg";
	}
	
	protected UploadTempPath getCurrentUploadTempPath(){
		return uploadImageTempStorage.getCurrentUploadTempPath();
	}
	
	protected void transferUploadToFile(MultipartFile uploadPhoto, Path destPath) throws IOException {
		String contentType = uploadPhoto.getContentType();
		LOGGER.debug("Content type for upload {}", contentType);
		uploadPhoto.transferTo(destPath.toFile());
		if (contentType.contains("png")) {
			pngToJpegImageFormatConverter.convertImage(destPath, destPath);
		} else if (!contentType.contains("jpg") && !contentType.contains("jpeg")) {
			throw new CantCompleteClientRequestException("Only png and jpg image formats are supported: Current content type=" + contentType);
		}
	}
}
