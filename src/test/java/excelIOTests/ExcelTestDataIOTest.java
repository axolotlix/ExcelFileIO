package excelIOTests;

import org.junit.BeforeClass;
import org.junit.Test;
import utils.ExcelTestDataIO;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ExcelTestDataIOTest {

    private static ExcelTestDataIO io;
    private static final String READ_FILENAME = "exampletestdata";
    private static final String WRITE_FILENAME = "exampletestdata(2)";
    private static final String TEST_DATA_DIR = "testexceldocs\\";
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin";

    @BeforeClass
    public static void setup() {
        io = new ExcelTestDataIO();
    }

    @Test
    public void readXLSTest() {
        String ext = ".xls";
        assertTrue("File contents not equal", io.readTestInputsXLS(TEST_DATA_DIR + READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void readXLSXTest() {
        String ext = ".xlsx";
        assertTrue("File contents not equal", io.readTestInputsXLSX(TEST_DATA_DIR + READ_FILENAME + ext).get("username").equals(USERNAME));
    }

    @Test
    public void writeXLSTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xls";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSFile(TEST_DATA_DIR + WRITE_FILENAME + ext, "Sheet1", data);
        assertTrue("File contents not equal", io.readTestInputsXLS(TEST_DATA_DIR + WRITE_FILENAME + ext).get("password").equals(PASSWORD));
    }

    @Test
    public void writeXLSXTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".xlsx";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeXLSXFile(TEST_DATA_DIR + WRITE_FILENAME + ext, "Sheet1", data);
        assertTrue("File contents not equal", io.readTestInputsXLSX(TEST_DATA_DIR + WRITE_FILENAME + ext).get("password").equals(PASSWORD));
    }

    @Test
    public void readCSVTest() {
        String ext = ".csv";
        assertTrue("File contents not equal", io.readCSV(TEST_DATA_DIR + READ_FILENAME + ext).get(0).get(1).equals(USERNAME));
    }

    @Test
    public void writeCSVTest() {
        List<List<String>> data = new ArrayList<>();
        String ext = ".csv";
        data.add(TestHelper.getLineOne());
        data.add(TestHelper.getLineTwo());
        io.writeCSV(TEST_DATA_DIR + WRITE_FILENAME + ext, data);
        assertTrue("File contents not equal", io.readCSV(TEST_DATA_DIR + WRITE_FILENAME + ext).get(0).get(1).equals(USERNAME));
    }
}
