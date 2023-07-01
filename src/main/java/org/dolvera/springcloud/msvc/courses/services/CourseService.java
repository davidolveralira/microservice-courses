package org.dolvera.springcloud.msvc.courses.services;

import org.dolvera.springcloud.msvc.courses.models.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();
    Optional<Course> byId(Long id);
    Course save(Course course);
    void delete(Long id);

}
