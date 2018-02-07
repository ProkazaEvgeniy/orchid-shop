package net.www.orchid.service;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.model.UploadResult;

public interface ImageProcessorService {

	@Nonnull UploadResult processNewProductPhoto(@Nonnull MultipartFile uploadPhoto);
}
