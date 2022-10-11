package tech.hdurmaz.sms.exception;

public class CourseIsNotExistException extends RuntimeException{
    public CourseIsNotExistException(String message){
        super(message);
    }
}
