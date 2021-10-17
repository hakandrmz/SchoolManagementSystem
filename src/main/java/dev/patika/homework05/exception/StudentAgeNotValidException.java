package dev.patika.homework05.exception;

public class StudentAgeNotValidException extends RuntimeException{
    public StudentAgeNotValidException(String msg){
        super(msg);
    }
}
