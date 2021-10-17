package dev.patika.homework05.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg){
        super(msg);
    }
}
