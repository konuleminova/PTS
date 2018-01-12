package crocusoft.android.myapp.pts.network.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 1/11/2018.
 */

public class ForgotPassResponseClass {
    MessageClass message;

    public ForgotPassResponseClass(MessageClass message) {
        this.message = message;
    }

    public MessageClass getMessage() {
        return message;
    }

    public void setMessage(MessageClass message) {
        this.message = message;
    }
}
