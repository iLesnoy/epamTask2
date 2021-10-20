package epam.task.shapes.filereader;

import epam.task.shapes.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomFileReaderTest {

    @DisplayName("readValues")
    @Test
    void readValues() throws CustomException {

        List<String> actualList = CustomFileReader.readValues("resources/file.txt");
        List<String> expectedList = List.of("-4.0 8.0 5.0 1.4 1.6");
        assertEquals(actualList, expectedList);

    }
}