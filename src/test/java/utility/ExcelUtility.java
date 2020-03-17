package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	public static Object[][] getData(String fileName) throws IOException {
		Object[][] result = null;

		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			if (sheet.getLastRowNum() <= 0)
				return result;
			int colCount = sheet.getRow(0).getLastCellNum();
			int rowCnt = sheet.getLastRowNum();
			result = new Object[rowCnt][colCount];
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();

				if (row.getRowNum() == 0) {
					continue;
				}
				Iterator cells = row.cellIterator();
				String s = "";
				while (cells.hasNext()) {
					cell = (XSSFCell) cells.next();
					
					s = cell.getStringCellValue();
					// System.out.println((cell.getRowIndex() - 1) + "," +
					// cell.getColumnIndex() + " = " + s);
					result[cell.getRowIndex() - 1][cell.getColumnIndex()] = s;

				}
			}
		} catch (FileNotFoundException e) {
			throw e;
		}
		// System.out.println(result);
		return result;
	}

}
