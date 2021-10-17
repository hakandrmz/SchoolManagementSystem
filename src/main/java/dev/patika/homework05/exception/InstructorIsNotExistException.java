package dev.patika.homework05.exception;

public class InstructorIsNotExistException extends RuntimeException{
    public InstructorIsNotExistException(String message){
        super(message);
    }
}
