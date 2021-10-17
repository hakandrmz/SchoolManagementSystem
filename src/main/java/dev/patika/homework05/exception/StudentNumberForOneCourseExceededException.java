package dev.patika.homework05.exception;

public class StudentNumberForOneCourseExceededException extends RuntimeException{
    public StudentNumberForOneCourseExceededException(String msg){
        super(msg);
    }
}
