package tech.hdurmaz.sms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hdurmaz.sms.dto.StudentDTO;
import tech.hdurmaz.sms.entity.Student;
import tech.hdurmaz.sms.service.StudentService;

/*

java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 .\sms-0.0.1-SNAPSHOT.jar

 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<StudentDTO> getAllStudents() {
        return new ResponseEntity(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long id) {
        return new ResponseEntity(studentService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("student/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>("Student with id: " + id + " deleted", HttpStatus.OK);
    }

    /**
     * @param studentDTO
     * @return saved student
     */
    @PostMapping("student/add")
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentDTO studentDTO) {
        Student savedStudent = studentService.save(studentDTO);
        return new ResponseEntity(savedStudent, HttpStatus.OK);
    }

    @PutMapping("student/update")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.update(studentDTO);
        return new ResponseEntity(studentDTO, HttpStatus.OK);
    }

    /**
     * method for adding student an existing course
     *
     * @param courseId
     * @param studentDTO
     * @return Student and couse info or throws an exception
     */
    @PostMapping("student/add/{courseId}")
    public ResponseEntity<StudentDTO> addAStudentToAnExistingCourse(@PathVariable long courseId, @RequestBody StudentDTO studentDTO) {
        studentService.addAStudentToAnExistingCourse(courseId, studentDTO);
        return new ResponseEntity(String.format("Student Name: %s added to %d", studentDTO.getName(), courseId), HttpStatus.OK);
    }

    @GetMapping("students/search/{keyword}")
    public ResponseEntity<StudentDTO> searchStudent(@PathVariable String keyword) {
        return new ResponseEntity(studentService.search(keyword), HttpStatus.OK);
    }

    @GetMapping("students/searchStudentByCourseId/{keyword}")
    public ResponseEntity<StudentDTO> searchStudentsByCourseCode(@PathVariable String keyword) {
        return new ResponseEntity(studentService.getStudentByCourse(keyword), HttpStatus.OK);
    }
}
