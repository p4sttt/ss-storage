package net.d4y2k.ssstorage.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    byte[] get(String id);

    String upload(MultipartFile file);

    boolean isImage(MultipartFile file);

}
