package net.www.orchid.service;

import java.nio.file.Path;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.www.orchid.Constants.UIImageType;

public interface ImageStorageService {
	
	@Nonnull String saveAndReturnImageLink (@Nonnull String imageName, @Nonnull UIImageType imageType, @Nonnull Path tempImageFile);

	void remove (@Nullable String ... imageLinks);
}
