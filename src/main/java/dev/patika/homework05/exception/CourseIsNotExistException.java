package dev.patika.homework05.exception;

public class CourseIsNotExistException extends RuntimeException{
    public CourseIsNotExistException(String message){
        super(message);
    }
}
