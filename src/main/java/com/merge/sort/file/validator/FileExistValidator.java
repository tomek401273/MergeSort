package com.merge.sort.file.validator;

import java.io.File;

public class FileExistValidator implements Validator{
    @Override
    public boolean isValid(String input) {
        File file= new File(input);
        return file.exists();
    }
}
