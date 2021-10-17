package dev.patika.homework05.exception;

public class InstructorIsAlreadyExistException extends RuntimeException{
    public InstructorIsAlreadyExistException(String message){
        super(message);
    }
}
