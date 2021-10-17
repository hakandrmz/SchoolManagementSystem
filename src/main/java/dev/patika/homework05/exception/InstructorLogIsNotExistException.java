package dev.patika.homework05.exception;

public class InstructorLogIsNotExistException extends RuntimeException{
    public InstructorLogIsNotExistException(String msg){
        super(msg);
    }
}
