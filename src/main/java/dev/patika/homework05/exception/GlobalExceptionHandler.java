package dev.patika.homework05.exception;


import dev.patika.homework05.entity.SystemLog;
import dev.patika.homework05.service.CustomLogService;
import dev.patika.homework05.utils.ErrorMessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private CustomLogService customLogService;

    @ExceptionHandler({InstructorLogIsNotExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(InstructorLogIsNotExistException exc){
        SystemLog log = new SystemLog();
        log.setType("InstructorLogIsNotExistException");
        log.setDescription("InstructorLogIsNotExistException");
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(CourseIsAlreadyExistException exc){
        SystemLog log = new SystemLog();
        log.setType("CourseIsAlreadyExistException");
        log.setDescription(ErrorMessageConstants.COURSE_IS_ALREADY_EXIST);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.CONFLICT,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }


    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(InstructorIsAlreadyExistException exc){
        SystemLog log = new SystemLog();
        log.setType("InstructorIsAlreadyExistException");
        log.setDescription(ErrorMessageConstants.INSTRUCTOR_PHONE_NUMBER_MUST_BE_UNIQUE);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(StudentAgeNotValidException exc){
        SystemLog log = new SystemLog();
        log.setType("StudentAgeNotValidException");
        log.setDescription(ErrorMessageConstants.STUDENT_AGE_NOT_VALID);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(StudentNumberForOneCourseExceededException exc){
        SystemLog log = new SystemLog();
        log.setType("StudentNumberForOneCourseExceededException");
        log.setDescription(ErrorMessageConstants.STUDENT_NUMBER_FOR_ONE_COURSE_EXCEED);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InstructorIsNotExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(InstructorIsNotExistException exc){
        SystemLog log = new SystemLog();
        log.setType("InstructorIsNotExistException");
        log.setDescription(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CourseIsNotExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(CourseIsNotExistException exc){
        SystemLog log = new SystemLog();
        log.setType("CourseIsNotExistException");
        log.setDescription(ErrorMessageConstants.COURSE_IS_NOT_EXIST);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(StudentNotFoundException exc){
        SystemLog log = new SystemLog();
        log.setType("StudentNotFoundException");
        log.setDescription(ErrorMessageConstants.STUDENT_IS_NOT_EXIST);
        customLogService.save(log);
        AppErrorResponse response = prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    private AppErrorResponse prepareErrorResponse(HttpStatus httpStatus, String message) {
        AppErrorResponse response = new AppErrorResponse();
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }

}
