package br.com.fiap.isee.controller;

public class ControllerNotFoundException extends RuntimeException{
    public ControllerNotFoundException(String message){
        super(message);
    }
}
