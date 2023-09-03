package com.example.diplomanet.chatroom;

public class RoomMessage {
    private String userEmail;
    private String message;
    private String dateTime;

    //For Firebase getting data back

    public RoomMessage(){
    }

    public RoomMessage(String userEmail, String message, String dateTime) {
        this.userEmail = userEmail;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSent(String userEmail) {
        return this.userEmail.equals(userEmail);
    }
}
