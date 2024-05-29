package br.com.fiap.isee.controller.exception;

public class ControllerBadRequestException extends RuntimeException{
    public ControllerBadRequestException(String message){
        super(message);
    }
}
