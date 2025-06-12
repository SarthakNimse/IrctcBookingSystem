package com.irctcbooking.model;

public class NotificationAlert {

    private int notificationAlertId;
    private int userId;
    private String type;
    private String message;
    private String dateTime;

    @Override
    public String toString() {
        return "NotificationAlert{" +
                "notificationAlertId=" + notificationAlertId +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

    public int getNotificationAlertId() {
        return notificationAlertId;
    }

    public void setNotificationAlertId(int notificationAlertId) {
        this.notificationAlertId = notificationAlertId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    }
