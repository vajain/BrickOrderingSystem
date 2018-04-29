package com.shop.exception;

/**
 * This is custom exception class through which custom messages can be propagated to UI.
 * 
 * @author Vaishali
 * @version 1.0
 */
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
    
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
 
}