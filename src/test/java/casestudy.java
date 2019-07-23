import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class casestudy {
	
  @Test
  public void readbook() throws IOException {
	  File src=new File("C:\\Users\\training_d2.03.07\\Desktop\\wb.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet1 = wb.getSheetAt(0);
	  int rowCount = sheet1.getLastRowNum();
	  System.out.println("total no of rows"+rowCount);
	  for(int i=0;i<=rowCount;i++)
	  {
		  String Data = sheet1.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("total no of rows"+Data);
		  String Data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("total no of rows"+Data1);
	  }
	  wb.close();
  }
  @Test
  public void writeexcel() throws IOException {
	  File src=new File("C:\\Users\\training_d2.03.07\\Desktop\\wb.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet1 = wb.getSheetAt(0);
	  int rowCount = sheet1.getLastRowNum();
	  System.out.println("total no of rows"+rowCount);
	  for(int i=0;i<=rowCount;i++)
	  {
		  String Data = sheet1.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("total no of rows"+Data);
		  String Data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("total no of rows"+Data1);
	  }
	  sheet1.getRow(0).createCell(2).setCellValue("Result");
	  sheet1.getRow(1).createCell(2).setCellValue("valid_user");
	  sheet1.getRow(2).createCell(2).setCellValue("valid_user");
	  FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\training_d2.03.07\\Desktop\\New folder\\demo_01\\abcd.xlsx"));
	  wb.write(fout);
	  fout.close();
  }
}
