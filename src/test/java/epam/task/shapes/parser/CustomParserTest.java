package epam.task.shapes.parser;

import epam.task.shapes.exception.CustomException;
import epam.task.shapes.filereader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomParserTest {

    @Test
    void stringParse() throws CustomException {
        List<String> actualList = CustomFileReader.readValues("resources/file.txt");
        String valuesString = String.join(" ",actualList);
        double [] expectedValues = {-4.0,8.0,5.0,1.4,1.6};
        double [] actualValues = CustomParser.stringParse(valuesString);
        assertArrayEquals(expectedValues,actualValues);

    }
}