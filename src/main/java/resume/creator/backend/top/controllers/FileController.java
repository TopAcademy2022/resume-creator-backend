package resume.creator.backend.top.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @GetMapping("/download")
    public ResponseEntity<Resource> GetFileResume(String fileName) {
        String directoryPath = "./files/";
        File file = new File(directoryPath + fileName);

        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Возвращаем 404 если файл не найден
        }

        FileSystemResource resource = new FileSystemResource(file);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }

    @PostMapping("/upload")
    public boolean SevFileResumeTemplate(MultipartFile  file){
        final String DirectoryPath = "files/";
        try {
            File dir = new File(DirectoryPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverFile = new File(dir.getAbsolutePath(), file.getOriginalFilename());
            file.transferTo(serverFile);

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
