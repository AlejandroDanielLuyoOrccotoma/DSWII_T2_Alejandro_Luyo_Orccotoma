package pe.cibertec.examen.T2_Alejandro_Luyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.cibertec.examen.T2_Alejandro_Luyo.service.FileService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Se deben subir exactamente 3 archivos");
        }

        for (MultipartFile file : files) {
            validateFileExtension(file);
            fileService.storeFile(file);
        }

        return new ResponseEntity<>("Archivos subidos exitosamente", HttpStatus.OK);
    }

    private void validateFileExtension(MultipartFile file) {
        String extension = getFileExtension(file.getOriginalFilename());
        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Extensión no permitida: " + extension);
        }
    }

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf('.') + 1);
    }
}
