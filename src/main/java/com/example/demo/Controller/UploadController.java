package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ejemplo.backend.model.UploadResponse;
import com.ejemplo.backend.service.UploadService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(new UploadResponse("Please upload a file."), HttpStatus.BAD_REQUEST);
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                return new ResponseEntity<>(new UploadResponse("Invalid file name."), HttpStatus.BAD_REQUEST);
            }

            // Lógica para manejar la carga del archivo y procesarlo
            UploadResponse response = uploadService.processUpload(file);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new UploadResponse("Failed to upload file."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
