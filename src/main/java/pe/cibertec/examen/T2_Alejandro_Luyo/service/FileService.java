package pe.cibertec.examen.T2_Alejandro_Luyo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    private final Path fileStorageLocation;

    public FileService() {
        this.fileStorageLocation = Paths.get("file_storage")
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo crear el directorio donde se almacenarán los archivos subidos.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Lo siento! El nombre del archivo contiene una secuencia de ruta inválida: " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo almacenar el archivo " + fileName + ". Por favor, inténtelo de nuevo!", ex);
        }
    }
}
