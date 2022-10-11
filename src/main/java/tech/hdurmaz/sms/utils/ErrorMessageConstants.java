package tech.hdurmaz.sms.utils;

public interface ErrorMessageConstants {
    String STUDENT_AGE_NOT_VALID = "Student age must be greater than 18 and less than 40";
    String INSTRUCTOR_PHONE_NUMBER_MUST_BE_UNIQUE = "Instructor phone number must be unique";
    String COURSE_IS_ALREADY_EXIST = "Course with this course code is already exist";
    String STUDENT_NUMBER_FOR_ONE_COURSE_EXCEED = "Student number of course must be less than 20";
    String INSTRUCTOR_IS_NOT_EXIST = "Instructor is not exist";
    String COURSE_IS_NOT_EXIST = "Course is not exist";
    String STUDENT_IS_NOT_EXIST = "Student is not exist";
    String INSTRUCTOR_LOG_IS_NOT_EXIST = "Instructor log is not exit";
}
