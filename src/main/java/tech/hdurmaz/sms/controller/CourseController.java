package tech.hdurmaz.sms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hdurmaz.sms.dto.CourseDTO;
import tech.hdurmaz.sms.entity.Course;
import tech.hdurmaz.sms.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<Course> getAllCourse(){
        List<Course> courseList = courseService.findAll();
        return new ResponseEntity(courseList,HttpStatus.OK);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long id){
        log.info("getCourseById request with id:" + id);
        return new ResponseEntity(courseService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("course/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable long id){
        log.info("deleteCourseById request with id:" + id);
        courseService.deleteById(id);
        return new ResponseEntity<>("Instructed with id " + id + " deleted",HttpStatus.OK);
    }

    @PostMapping("course/add")
    public ResponseEntity<Course> addNewCourse(@RequestBody CourseDTO courseDTO){
        Optional<Course> resultOptional = courseService.save(courseDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("course/update")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO){
        courseService.update(courseDTO);
        return new ResponseEntity(courseDTO, HttpStatus.OK);
    }
}
