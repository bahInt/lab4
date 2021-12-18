package lab4.assists;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PackageData {
    @JsonProperty("packageId")
    private final String packageId;
    @JsonProperty("jsScript")
    private final String jsScript;
    @JsonProperty("functionName")
    private final String functionName;
    @JsonProperty("tests")
    private final ArrayList<TestData> tests;
}
