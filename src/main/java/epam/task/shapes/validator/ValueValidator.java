package epam.task.shapes.validator;

import epam.task.shapes.entity.Point;

import java.util.regex.Pattern;

public class ValueValidator {

    private static final String regex_isnumber = "^-?\\d+\\.\\d+\\s+-?\\d+\\.\\d+\\s+\\d+\\.\\d+\\s\\d+\\.\\d+\\s\\d+\\.\\d+$";


    public static boolean fileValidator(String str) {
        var pattern = Pattern.compile(regex_isnumber);
        var mather = pattern.matcher(str);
        return mather.matches();
    }

}
