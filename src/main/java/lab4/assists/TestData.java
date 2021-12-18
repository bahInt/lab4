package lab4.assists;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestData {
    @JsonProperty("testName")
    private  final String testName;
    @JsonProperty("expectedResult")
    private final String expectedResult;
    private final ArrayList<Object> params;

    public TestData(String testName, String expectedResult, ArrayList<Object> params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public ArrayList<Object> getParams() {
        return params;
    }
}
