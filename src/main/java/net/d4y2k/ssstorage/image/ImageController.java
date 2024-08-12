package net.d4y2k.ssstorage.image;

import lombok.RequiredArgsConstructor;
import net.d4y2k.ssstorage.global.exception.ApiException;
import net.d4y2k.ssstorage.global.exception.ErrorType;
import net.d4y2k.ssstorage.global.success.SuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageId) {
        byte[] bytes = imageService.get(imageId);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new ApiException(ErrorType.EMPTY_FILE);
        }

        if (!imageService.isImage(file)) {
            throw new ApiException(ErrorType.FILE_NOT_IMAGE);
        }

        String imageId = imageService.upload(file);
        Map<String, String> data = Map.of("image_id", imageId);
        SuccessResponse responseBody = new SuccessResponse(data, "Image was successfully uploaded");

        return ResponseEntity.ok(responseBody);
    }

}
