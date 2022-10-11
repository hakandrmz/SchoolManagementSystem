package tech.hdurmaz.sms.exception;

public class InstructorIsAlreadyExistException extends RuntimeException{
    public InstructorIsAlreadyExistException(String message){
        super(message);
    }
}
