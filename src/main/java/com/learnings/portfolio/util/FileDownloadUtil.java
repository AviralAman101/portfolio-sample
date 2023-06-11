package com.learnings.portfolio.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtil {
    private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        System.out.println(cl.getName());
        System.out.println();
        Path dirPath = Paths.get(cl.getResource("./static/files/").getPath().replaceFirst("/",""));
        System.out.println(dirPath.getFileName());
        System.out.println(dirPath);
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}