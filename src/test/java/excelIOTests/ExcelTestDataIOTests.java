package excelIOTests;

import org.junit.BeforeClass;
import org.junit.Test;
import utils.ExcelTestDataIO;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ExcelTestDataIOTests {

    private static ExcelTestDataIO io;
    private static final String READ_FILENAME = "exampletestdata";
    private static final String WRITE_FILENAME = "exampletestdata(2)";
    private static final String USERNAME = "admin";

    @BeforeClass
    public void setup() {
        io = new ExcelTestDataIO();
    }

    @Test
    public void readXLSTest() {
        String ext = ".xls";
        assertTrue("File contents not equal", io.readTestInputsXLS(READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void readXLSXTest() {
        String ext = ".xlsx";
        assertTrue("File contents not equal", io.readTestInputsXLSX(READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void writeXLSTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xls";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSFile(WRITE_FILENAME + ext, "Sheet1", data);
        assertTrue("File contents not equal", io.readTestInputsXLS(WRITE_FILENAME + ext).get("password").equals("password123"));
    }

    @Test
    public void writeXLSXTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xlsx";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSXFile(WRITE_FILENAME + ext, "Sheet1", data);
        assertTrue("File contents not equal", io.readTestInputsXLSX(WRITE_FILENAME + ext).get("password").equals("password123"));
    }

    @Test
    public void readCSVTest() {
        String ext = ".csv";
        assertTrue("File contents not equal", io.readCSV(READ_FILENAME + ext).get(0).get(0).equals("username"));
    }

    @Test
    public void writeCSVTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".csv";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeCSV(WRITE_FILENAME + ext, data);
        assertTrue("File contents not equal", io.readCSV(WRITE_FILENAME + ext).get(0).get(0).equals("username"));
    }
}
