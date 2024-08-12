package net.d4y2k.ssstorage.global.utils;

import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileUtils {

    public static String extractExtension(@NonNull MultipartFile file) {
        String fileName = file.getOriginalFilename();

        if (fileName == null || !fileName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name: " + fileName);
        }

        int dotIndex = fileName.lastIndexOf(".");
        return fileName.substring(dotIndex + 1);
    }

}
