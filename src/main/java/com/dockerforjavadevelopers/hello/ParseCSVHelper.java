package com.dockerforjavadevelopers.hello;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class ParseCSVHelper {
    public static List<CSVRecord> parseCSVRecords(MultipartFile file) throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        return parser.getRecords();
    }
}
