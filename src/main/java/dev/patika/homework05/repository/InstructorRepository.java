package dev.patika.homework05.repository;


import dev.patika.homework05.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    Instructor findInstructorsByPhoneNumber(String word);
}
