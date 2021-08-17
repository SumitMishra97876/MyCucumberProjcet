package utils;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	public static List<Map<String, String>> data(String filepath,String sheetname)
	{
		List<Map<String,String>> mydata=new ArrayList<>();
		
		try
		{
			FileInputStream fs=new FileInputStream(filepath);
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			Row HeaderRow=sheet.getRow(0);
			
			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			{
				Row currentRow=sheet.getRow(i);
				HashMap<String,String> currMap=new HashMap<String,String>();
				
				for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
				{
					Cell currCell=currentRow.getCell(j);
					
					switch(currCell.getCellType())
					{
					case STRING:
						currMap.put(HeaderRow.getCell(j).getStringCellValue(),currCell.getStringCellValue());
					     break;
					}
				}
				
				mydata.add(currMap);
			}
			
			fs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mydata;
	}

}
