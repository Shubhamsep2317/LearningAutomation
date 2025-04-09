package DataDriven_ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcelVWOLogin {


    static Workbook book;
    static Sheet sheet;

    static String SHEET_PATH=System.getProperty("user.dir")+"/"+ "src/Test/java/Resources/Invalid_Login_Data_1.xlsx";

    public static Object[][] getExcelSheetData(String sheetName){

        FileInputStream file=null;

        try{
           file= new FileInputStream(SHEET_PATH);
           book= WorkbookFactory.create(file);
           sheet= book.getSheet(sheetName);
        }
        catch (IOException e)
        {
            System.out.println("Either Workbook or sheet not found");
        }

        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0;i< sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }

       return data;

    }

}
