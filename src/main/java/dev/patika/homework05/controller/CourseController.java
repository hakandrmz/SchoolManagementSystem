package dev.patika.homework05.controller;

import com.sun.xml.bind.v2.TODO;

import dev.patika.homework05.dto.CourseDTO;
import dev.patika.homework05.entity.Course;
import dev.patika.homework05.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<Course> getAllCourse(){
        Optional<List<Course>> resultOptional = Optional.ofNullable(courseService.findAll());
        if(resultOptional.isPresent()){
            return new ResponseEntity(resultOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long id){
        return new ResponseEntity(courseService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("course/delete/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable long id){
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
