package excelIOTests;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static List<String> getLineOne() {
        ArrayList<String> lineOne = new ArrayList<>();
        lineOne.add("username");
        lineOne.add("admin");
        lineOne.add("pass");
        return lineOne;
    }

    public static List<String> getLineTwo() {
        ArrayList<String> lineTwo = new ArrayList<>();
        lineTwo.add("password");
        lineTwo.add("password123");
        lineTwo.add("pass");
        return lineTwo;
    }
}
