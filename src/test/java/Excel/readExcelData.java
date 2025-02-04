package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelData {

	public static void main(String[] args) throws IOException {


		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\Bug_Report_Juice_Shop.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getLastRowNum();
		int shell=sheet.getRow(1).getLastCellNum();
		
		for(int i=0;i<=row;i++) {
		
			XSSFRow currow=sheet.getRow(i); 
			
			for(int j=1;j<shell;j++) {
				XSSFCell cell=currow.getCell(j);
				System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}
		

		workbook.close();
		file.close();
		
	}

}
