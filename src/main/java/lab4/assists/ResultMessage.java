package lab4.assists;

import java.util.ArrayList;

public class ResultMessage {
    private final String packID;
    private final ArrayList<String> results;

    public ResultMessage(String packID, ArrayList<String> results) {
        this.packID = packID;
        this.results = results;
    }

    public String getPackID() {
        return packID;
    }

    public ArrayList<String> getResults() {
        
    }
}
