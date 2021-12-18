package lab4.messages;

import java.io.Serializable;

public class PutMessage {
    private  final String packID, result;

    public PutMessage(String packID, String result) {
        this.packID = packID;
        this.result = result;
    }

    public String getPackID() {
        return packID;
    }

    public String getResult() {
        return result;
    }
}
