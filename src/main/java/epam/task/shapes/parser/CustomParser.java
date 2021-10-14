package epam.task.shapes.parser;


public class CustomParser {
    private static final String SPACE = "\\s+";


    public static double[] stringParse(String str) {
        String[] numberArr = str.split(SPACE);
        double[] numbers = new double[numberArr.length];
        for (int i = 0; i < numberArr.length; i++) {
            numbers[i] = Double.parseDouble(numberArr[i]);
        }
        return numbers;
    }
}
