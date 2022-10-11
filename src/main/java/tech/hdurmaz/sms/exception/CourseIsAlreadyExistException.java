package tech.hdurmaz.sms.exception;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String msg){
        super(msg);
    }
}
