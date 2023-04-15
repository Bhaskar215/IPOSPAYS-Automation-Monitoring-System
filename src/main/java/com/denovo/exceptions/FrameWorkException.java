package com.denovo.exceptions;

public class FrameWorkException extends RuntimeException{

    public FrameWorkException(String message){
        super(message);
    }

    public FrameWorkException(String message,Throwable cause){
        super(message,cause);
    }

}
