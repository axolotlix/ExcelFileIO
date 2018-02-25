package excelIOTests;

import utils.ExcelTestDataIO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExcelTestDataIOTests {

    private ExcelTestDataIO io;
    private static final String READ_FILENAME = "testdata";
    private static final String WRITE_FILENAME = "newtestdata";
    private static final String USERNAME = "admin";

    @Before
    public void setup() {
        io = new ExcelTestDataIO();
    }

    @Test
    public void readXLSTest() {
        String ext = ".xls";
        assert(io.readTestInputsXLS(READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void readXLSXTest() {
        String ext = ".xlsx";
        assert(io.readTestInputsXLSX(READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void writeXLSTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xls";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSFile(WRITE_FILENAME + ext, "Sheet1", data);
        assert(io.readTestInputsXLS(WRITE_FILENAME + ext).get("password").equals("password123"));
    }

    @Test
    public void writeXLSXTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xlsx";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSXFile(WRITE_FILENAME + ext, "Sheet1", data);
        assert(io.readTestInputsXLSX(WRITE_FILENAME + ext).get("password").equals("password123"));
    }

    @Test
    public void readCSVTest() {
        String ext = ".csv";
        assert(io.readCSV(READ_FILENAME + ext).get(0).get(0).equals("username"));
    }

    @Test
    public void writeCSVTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".csv";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeCSV(WRITE_FILENAME + ext, data);
        assert(io.readCSV(WRITE_FILENAME + ext).get(0).get(0).equals("username"));
    }
}
