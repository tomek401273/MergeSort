package com.merge.sort.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppConfigTest {
    @Test
    public void fileExit(){
        String inputFileString= "input/test/input-person-list.txt"; // wczytaj tą zmienną ze skanera
        String outputFileString ="output/test/output-test1.txt"; // wczytaj tą zmienną ze skanera
        AppConfig appConfig= new AppConfig(inputFileString, outputFileString);
        Assertions.assertTrue(appConfig.isAppConfigValid());
    }
    @Test
    public void inputFileNotExit(){
        String inputFileString= "input/test/input-person-list2.txt"; // wczytaj tą zmienną ze skanera
        String outputFileString ="output/test/output-test1.txt"; // wczytaj tą zmienną ze skanera
        AppConfig appConfig= new AppConfig(inputFileString, outputFileString);
        Assertions.assertFalse(appConfig.isAppConfigValid());
    }
    @Test
    public void outputFileNotExit(){
        String inputFileString= "input/test/input-person-list.txt"; // wczytaj tą zmienną ze skanera
        String outputFileString ="output/test/output-testfsdfs1.txt"; // wczytaj tą zmienną ze skanera
        AppConfig appConfig= new AppConfig(inputFileString, outputFileString);
        Assertions.assertFalse(appConfig.isAppConfigValid());
    }
    @Test
    public void closeProgram(){
        System.out.println("appConfig not valid close program");
        System.exit(0);
        System.out.println("after program ends");
    }
}