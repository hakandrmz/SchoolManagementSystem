package tech.hdurmaz.sms.exception;

public class StudentNumberForOneCourseExceededException extends RuntimeException{
    public StudentNumberForOneCourseExceededException(String msg){
        super(msg);
    }
}
