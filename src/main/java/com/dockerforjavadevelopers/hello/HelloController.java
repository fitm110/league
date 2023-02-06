package com.dockerforjavadevelopers.hello;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class HelloController {
    //curl -F 'file=@./matrix.csv' "localhost:8080/csv"

    @Autowired
    private MatrixOperationService matrixOperationService;
    
    @PostMapping("/echo")
    public ResponseEntity<String> echoCSV(@RequestParam("file") MultipartFile file) throws IOException {
        List<CSVRecord> records = ParseCSVHelper.parseCSVRecords(file);
        return ResponseEntity.ok().body(matrixOperationService.echo(records));
    }

    @PostMapping("/flatten")
    public ResponseEntity<String> flattenCSV(@RequestParam("file") MultipartFile file) throws IOException {
        List<CSVRecord> records = ParseCSVHelper.parseCSVRecords(file);
        return ResponseEntity.ok().body(matrixOperationService.flatten(records));
    }

    @PostMapping("/invert")
    public ResponseEntity<String> invertCSV(@RequestParam("file") MultipartFile file) throws IOException {
        List<CSVRecord> records = ParseCSVHelper.parseCSVRecords(file);
        return ResponseEntity.ok().body(matrixOperationService.invert(records));
    }

    @PostMapping("/sum")
    public ResponseEntity<String> sumCSV(@RequestParam("file") MultipartFile file) throws IOException {
        List<CSVRecord> records = ParseCSVHelper.parseCSVRecords(file);
        return ResponseEntity.ok().body(matrixOperationService.sum(records) + "\n");
    }

    @PostMapping("/multiply")
    public ResponseEntity<String> multiplyCSV(@RequestParam("file") MultipartFile file) throws IOException {
        List<CSVRecord> records = ParseCSVHelper.parseCSVRecords(file);
        return ResponseEntity.ok().body(matrixOperationService.multiply(records) + "\n");
    }
    
}
