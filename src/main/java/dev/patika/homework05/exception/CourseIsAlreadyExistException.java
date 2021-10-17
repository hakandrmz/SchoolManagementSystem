package dev.patika.homework05.exception;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String msg){
        super(msg);
    }
}
