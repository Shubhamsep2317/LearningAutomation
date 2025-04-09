package DataDriven_ApachePOI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDriven_Testcases {


    @Test(dataProvider = "getExcelData")
    public void login(String username, String password) {

        System.out.println("The username " + username + " and the " + password);
    }

    @DataProvider
    public Object[][] getExcelData() {
        return UtilExcel.getTestDataFromExcel("Sheet1");
    }
}
