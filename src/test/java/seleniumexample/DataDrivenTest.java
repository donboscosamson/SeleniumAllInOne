package seleniumexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public static void main(String[] args) throws FileNotFoundException
	{
	
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/resources/TestInputData.xlsx");
		try {
			XSSFWorkbook book=new XSSFWorkbook(fi);
			XSSFSheet sheet=book.getSheetAt(0);
			int rowCount=sheet.getLastRowNum();
			int colCount=sheet.getRow(0).getLastCellNum();
			
			System.out.println(sheet.getRow(rowCount).getCell(0).getStringCellValue());
			System.out.println(rowCount + ":"+ colCount);
			for(int row=1;row<=rowCount;row++)
			{
				for(int col=0;col<colCount;col++)
			{
					String value=sheet.getRow(row).getCell(col).getStringCellValue();
					System.out.println(value);
				
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		 
}
