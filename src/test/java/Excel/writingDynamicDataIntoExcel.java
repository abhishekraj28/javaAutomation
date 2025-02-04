package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {


		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\dynamicFile.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook();
		 XSSFSheet sheet=workbook.createSheet("dynamicData");
		 
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the no of rows: ");
		int noOfRows=scn.nextInt();
		
		System.out.println("Enter the no of cells");
		int noOfCells=scn.nextInt();
		
		for(int i=0;i<=noOfRows;i++) {
			
			XSSFRow currRow=sheet.createRow(i);
			
			for(int j=0;j<noOfCells;j++) {
				
				XSSFCell cell=currRow.createCell(j);
				cell.setCellValue(scn.next());
				
				
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();

	}

}
