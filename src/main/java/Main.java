import epam.task.shapes.exception.CustomException;
import epam.task.shapes.filereader.CustomFileReader;
import epam.task.shapes.parser.CustomParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Main {

    public static void main(String[] args) throws  CustomException {


        List<String> str = CustomFileReader.readAllFile("resources/file.txt");

        String string = String.join(" ",str);
        double [] arr = CustomParser.stringParse(string);
        for (double a:arr) {
            System.out.println(a);
        }

    }
}
