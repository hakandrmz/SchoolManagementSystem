package tech.hdurmaz.sms.exception;

public class StudentAgeNotValidException extends RuntimeException{
    public StudentAgeNotValidException(String msg){
        super(msg);
    }
}
