package ExcelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

	
	public static FileInputStream fi;
	public static FileOutputStream fo;	
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	
	public static int getRow(String xlFile, String xlSheet) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
		
	}

	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		
	}
	
	
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		String data;
		try {
			
			//we can use anyone of them
			//data=cell.toString();
			DataFormatter format=new DataFormatter();
			data=format.formatCellValue(cell);
			
			
		}
		catch(Exception e) {
			data="";
		}
		
		wb.close();
		fi.close();
		return data;
		
		
	}
	
	
	//In this method we are reading and writing the data both
	public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
		
	
	public static void fillGreenColors(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	public static void fillRedColors(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(colNum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
	}



}
