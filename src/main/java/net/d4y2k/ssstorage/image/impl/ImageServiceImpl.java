package net.d4y2k.ssstorage.image.impl;

import lombok.NonNull;
import net.d4y2k.ssstorage.global.exception.ApiException;
import net.d4y2k.ssstorage.global.exception.ErrorType;
import net.d4y2k.ssstorage.global.utils.MultipartFileUtils;
import net.d4y2k.ssstorage.image.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Path UPLOAD_DIR = Paths.get(System.getProperty("user.home"), "ss-storage", "upload", "image");
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>();
    private static final Set<String> ALLOWED_CONTENT_TYPES = new HashSet<>();

    static {
        ALLOWED_EXTENSIONS.add("jpg");
        ALLOWED_EXTENSIONS.add("png");

        ALLOWED_CONTENT_TYPES.add("image/jpeg");
        ALLOWED_CONTENT_TYPES.add("image/png");
    }

    @Override
    public byte[] get(String id) {
        try {
            Path filePath = UPLOAD_DIR.resolve(id);
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new ApiException(ErrorType.FAILED_GET_FILE);
        }
    }

    @Override
    public String upload(@NonNull MultipartFile file) {
        try {
            Files.createDirectories(UPLOAD_DIR);

            String fileId = UUID.randomUUID().toString();
            Path uploadPath = Paths.get(UPLOAD_DIR.toString(), fileId);
            Files.copy(file.getInputStream(), uploadPath);

            return fileId;
        } catch (IOException e) {
            throw new ApiException(ErrorType.FAILED_UPLOAD_FILE);
        }
    }

    @Override
    public boolean isImage(@NonNull MultipartFile file) {
        String contentType = file.getContentType();
        boolean isImageContentType = (contentType != null && ALLOWED_CONTENT_TYPES.contains(contentType));

        String extension = MultipartFileUtils.extractExtension(file);
        boolean isImageExtension = ALLOWED_EXTENSIONS.contains(extension);

        return isImageContentType && isImageExtension;
    }
}
