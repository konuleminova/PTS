package crocusoft.android.myapp.pts.network.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 1/10/2018.
 */

public class LoginResponseClass {
    String firstName;
    String lastName;
    String username;
    String email;
    String phone;
    String transactionId;
    String company;
    MessageClass message;

    public LoginResponseClass(MessageClass message) {
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public MessageClass getMessage() {
        return message;
    }

    public void setMessage(MessageClass message) {
        this.message = message;
    }
}

