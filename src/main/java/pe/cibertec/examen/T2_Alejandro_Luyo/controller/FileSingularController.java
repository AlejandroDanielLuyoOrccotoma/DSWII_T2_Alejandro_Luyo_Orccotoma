package pe.cibertec.examen.T2_Alejandro_Luyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.cibertec.examen.T2_Alejandro_Luyo.service.FileService;

@RestController
@RequestMapping("/api/v1/files")
public class FileSingularController {

    private static final long MAX_FILE_SIZE = 25 * 1024 * 1024; // 25MB

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadSingular")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo excede el tamaño máximo permitido de 25MB");
        }

        fileService.storeFile(file);

        return new ResponseEntity<>("Archivo subido exitosamente", HttpStatus.OK);
    }
}
