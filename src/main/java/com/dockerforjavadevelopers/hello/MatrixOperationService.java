package com.dockerforjavadevelopers.hello;

import org.apache.commons.csv.CSVRecord;

import java.util.List;

public interface MatrixOperationService {
    public String echo(List<CSVRecord> records);
    public String invert(List<CSVRecord> records);
    public String flatten(List<CSVRecord> records);
    public String sum(List<CSVRecord> records);
    public String multiply(List<CSVRecord> records);

}
