package com.learnings.portfolio.controller;

import com.learnings.portfolio.repository.MessageRepository;
import com.learnings.portfolio.service.PortfolioService;
import com.learnings.portfolio.util.FileDownloadUtil;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class AsyncRestController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/{email}/{message}")
    public void store(@PathVariable String email,@PathVariable String message){
        portfolioService.saveMessage(email, message);
    }

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading");
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            System.out.println("Error reading2");
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
