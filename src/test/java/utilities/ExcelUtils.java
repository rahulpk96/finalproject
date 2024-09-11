package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][columnCount];

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip the header row

            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = row.getCell(j).toString();
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
