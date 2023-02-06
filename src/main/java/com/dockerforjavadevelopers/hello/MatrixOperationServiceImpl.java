package com.dockerforjavadevelopers.hello;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatrixOperationServiceImpl implements MatrixOperationService {
    @Override
    public String echo(List<CSVRecord> records) {
        StringBuilder result = new StringBuilder();
        for (CSVRecord record : records) {
            List<String> list = new ArrayList<>();
            for (int i=0; i<record.size(); i++) {
                list.add(record.get(i));
            }
            result.append(String.join(",", list));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String invert(List<CSVRecord> records) {
        StringBuilder result = new StringBuilder();
        String[][] matrix = new String[records.size()][records.get(0).size()];
        for (int i=0; i<records.size(); i++) {
            for (int j=0; j<records.get(i).size(); j++) {
                matrix[j][i] = records.get(i).get(j);
            }
        }
        for (String[] row : matrix) {
            List<String> list = new ArrayList<>(Arrays.asList(row));
            result.append(String.join(",", list));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String flatten(List<CSVRecord> records) {
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (CSVRecord record : records) {
            for (int i=0; i<record.size(); i++) {
                list.add(record.get(i));
            }
        }
        result.append(String.join(",", list));
        result.append("\n");
        return result.toString();
    }

    @Override
    public String sum(List<CSVRecord> records) {
        int sum = 0;
        for (CSVRecord record : records) {
            for (int i=0; i<record.size(); i++) {
                sum += Integer.parseInt(record.get(i));
            }
        }
        return String.valueOf(sum);
    }

    @Override
    public String multiply(List<CSVRecord> records) {
        if (records.isEmpty()) return String.valueOf(0);
        int product = 1;
        for (CSVRecord record : records) {
            for (int i=0; i<record.size(); i++) {
                product *= Integer.parseInt(record.get(i));
            }
        }
        return String.valueOf(product);
    }
}
