package com.mrbonk.instrumenttrade.utils;

import com.mrbonk.instrumenttrade.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class MediaFileUtils {
    private static final Path rootLocation = Path.of("").toAbsolutePath().resolve("storage");

    public static Image convertMultiPartFile(MultipartFile multipartFile) throws IOException {
        String contentType = multipartFile.getContentType().split("/")[1];
        String fileName = UUID.randomUUID() + "." + contentType;
        Path destinationFilePath = rootLocation.resolve(Path.of(fileName)).normalize().toAbsolutePath();
        Files.copy(multipartFile.getInputStream(), destinationFilePath);

        return new Image(multipartFile.getOriginalFilename(), destinationFilePath, multipartFile.getSize());
    }
}