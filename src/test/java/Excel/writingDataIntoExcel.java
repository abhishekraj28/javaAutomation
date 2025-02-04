package Excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDataIntoExcel {

	public static void main(String[] args) throws IOException {


		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\myFile.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook();
		 XSSFSheet sheet=workbook.createSheet("Data");
		 
		 XSSFRow row1=sheet.createRow(0);
		 row1.createCell(0).setCellValue(false);
		 row1.createCell(1).setCellValue(123);
		 row1.createCell(2).setCellValue("john");
		 row1.createCell(3).setCellValue("abc123");
		 
		 XSSFRow row2=sheet.createRow(1);
		 row2.createCell(0).setCellValue(true);
		 row2.createCell(1).setCellValue(456);
		 row2.createCell(2).setCellValue("vick");
		 row2.createCell(3).setCellValue("xyz123");
		 
		 workbook.write(file);
		 workbook.close();
		 file.close();


	}

}
