package epam.task.shapes.filereader;

import epam.task.shapes.exception.CustomException;
import epam.task.shapes.validator.ValueValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {


    private final static Logger logger = LogManager.getLogger();


    public static List<String> readValues(String filepath) throws CustomException {
        List<String> list;
        Path path = Paths.get(filepath);
        try {

            list = Files.lines(path).filter(ValueValidator::fileValidator).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new CustomException("File not found " + filepath,e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
        return list;
    }
}

