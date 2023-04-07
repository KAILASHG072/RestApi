package com.bike.repair.Controller.customer.service;

import com.bike.repair.Controller.customer.entity.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {
    public FileDB store(MultipartFile file) throws IOException;

    public FileDB getFile(String id);

    public Stream<FileDB> getAllFiles();

    FileDB DpToUser(String id , String username);
}
