package com.transcore.qa.mdtanoncore.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class FileUtil {

    final static String DATA_SEPARATOR = "=";

    public void saveMapToFile(Map<String, String> mapData, String filePath) {
        try {
            Files.write(Path.of(filePath), () -> mapData.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + DATA_SEPARATOR + e.getValue())
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> readMapFromFile(String filePath) {
        Map<String, String> mapData = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
            lines.forEach(line -> {
                String[] split = line.split(DATA_SEPARATOR);
                mapData.put(split[0],split[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapData;
    }
}
