package tests.testdata;

import org.testng.annotations.DataProvider;

public class Cities {

    @DataProvider(name="cities")
    public Object[][] getData(){
        return new Object[][]{
                {"Paris","Cairo"},
                {"Boston","New York"},
                {"Portland","Berlin"}
        };
    }
}
