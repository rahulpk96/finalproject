package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Kkrpageclass;
import utilities.ExcelUtils;

public class KkrtestpageDataDriven extends Baseclass {

    private Kkrpageclass kkrPage;

    @BeforeClass 
    public void setUp() {
        kkrPage = new Kkrpageclass(driver);
    }

    @DataProvider(name = "formData")
    public Object[][] getDataFromExcel() {
        String filePath = "C:\\Users\\USER\\Documents//projectxl.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "formData")
    public void testValidFormSubmission(String name, String phone, String email, String place, String age, String patientType, String gender, String date, String time) throws InterruptedException {
        kkrPage.enterName(name);
        kkrPage.enterPhone(phone);
        kkrPage.enterEmail(email);
        kkrPage.enterPlace(place);
        kkrPage.enterAge(age);
        kkrPage.selectPatientType(patientType);
        kkrPage.selectGender(gender);
        kkrPage.selectDate(date);
        kkrPage.selectTime(time);
        kkrPage.clickSubmit();

        // Verify success message
        String successMessage = kkrPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Booking Successful");
    }
}
