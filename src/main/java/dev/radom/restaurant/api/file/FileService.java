package dev.radom.restaurant.api.file;

import dev.radom.restaurant.api.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    Resource downloadByName(String name);
    FileDto uploadSingle(MultipartFile file);
    List<FileDto> uploadMultiple(List<MultipartFile> files);
    FileDto findByName(String name);
    void deleteAll();
    List<FileDto> findAll();

    void deleteByName(String name);

}
