package lab4.assists;

import java.util.ArrayList;

public class TestData {
    private  final String testName;
    private final String expectedResult;
    private final ArrayList<Object> params;

    public TestData(String testName, String expectedResult, ArrayList<Object> params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    
}
