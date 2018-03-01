package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExcelTestDataIO {

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\";

    public Map<String, String> readTestInputsXLS(String filename) {
        Map<String, String> data = new HashMap<>();
        try (HSSFWorkbook wb = new HSSFWorkbook(Files.newInputStream(Paths.get(RESOURCE_PATH + filename)))) {
            DataFormatter formatter = new DataFormatter();
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell typeCell, dataCell;
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                typeCell = row.getCell(0);
                dataCell = row.getCell(1);
                data.put(formatter.formatCellValue(typeCell), formatter.formatCellValue(dataCell));
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return data;
    }
    public void writeXLSFile(String filename, String sheetname, List<List<String>> data) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetname);

        for (int r = 0; r < data.size(); r++) {
            HSSFRow row = sheet.createRow(r);
            int i = 0;
            for (String column : data.get(r)) {
                HSSFCell cell = row.createCell(i++);
                cell.setCellValue(column);
            }
        }
        writeFile(wb, filename);
    }

    public Map<String, String> readTestInputsXLSX(String filename) {
        Map<String, String> data = new HashMap<>();
        try (XSSFWorkbook wb = new XSSFWorkbook(Files.newInputStream(Paths.get(RESOURCE_PATH + filename)))) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell typeCell, dataCell;
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()) {
                row = (XSSFRow) rows.next();
                typeCell = row.getCell(0);
                dataCell = row.getCell(1);
                data.put(formatter.formatCellValue(typeCell), formatter.formatCellValue(dataCell));
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return data;
    }
    public void writeXLSXFile(String filename, String sheetname, List<List<String>> data) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetname);

        for (int r = 0; r < data.size(); r++) {
            XSSFRow row = sheet.createRow(r);
            int i = 0;
            for (String column : data.get(r)) {
                XSSFCell cell = row.createCell(i++);
                cell.setCellValue(column);
            }
        }
        writeFile(wb, filename);
    }
    public List<List<String>> readCSV(String filename){
        List<List<String>> data = new ArrayList<>();
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(RESOURCE_PATH + filename))){
            while ((line = reader.readLine()) != null) {
                ArrayList<String> cells = new ArrayList<>();
                Collections.addAll(cells, line.split(","));
                data.add(cells);
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return data;
    }
    public void writeCSV(String filename, List<List<String>> data) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(RESOURCE_PATH + filename))){
            for (List<String> line : data){
                for (int k = 0; k < line.size(); k++) {
                    writer.write(line.get(k));
                    if (k < line.size() - 1)
                        writer.write(",");
                    else
                        writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    private void writeFile(Workbook wb, String filename) {
        try (OutputStream fileOut = Files.newOutputStream(Paths.get(RESOURCE_PATH + filename))){
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
