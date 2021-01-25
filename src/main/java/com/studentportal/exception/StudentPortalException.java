/**
 * I create this custom exception class to learn which part of code cause problem while which object used by.
 * ErrorCode is a Enum class. It has  exception type.
 * @Author Muhammed Yilmaz
 */


package com.studentportal.exception;
public class StudentPortalException extends Exception {
    private static final long serialVersionUID = 7718828512143293558L;
    private String message;
    public StudentPortalException(String message, Throwable e){
        super(message,e);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}