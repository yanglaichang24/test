package com.ylch.test.commmons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by yanglaichang1 on 2017/8/31.
 */
public class CsvTest {

    public static void main(String[] args) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
        FileWriter fileWriter = new FileWriter("");
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
    }


}
