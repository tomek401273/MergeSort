package com.merge.sort;

import com.merge.sort.config.AppConfig;
import com.merge.sort.file.reader.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

class FileReaderTest {
    @Test
    public void readTestLines(){
        AppConfig.setInputFilePath("input/test/input-test1.txt");
        Path pathToFile= AppConfig.getInputFilePath();
        FileReader fileReader = new FileReader();
        List<String> lines= fileReader.getInputLines(pathToFile);
        for (int i = 0; i < lines.size(); i++) {
            String l = lines.get(i);
            System.out.println("Lista: " + l);
        }
        Assertions.assertEquals(3, lines.size());
    }

}