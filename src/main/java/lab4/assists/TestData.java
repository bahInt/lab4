package lab4.assists;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestData {
    @JsonProperty("testName")
    private  final String testName;
    @JsonProperty("expectedResult")
    private final String expectedResult;
    @JsonProperty("params")
    private final ArrayList<Object> params;

    @JsonCreator
    public TestData(@JsonProperty("testName") String testName,
                    @JsonProperty("expectedResult")String expectedResult,
                    @JsonProperty("params")ArrayList<Object> params) {
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
