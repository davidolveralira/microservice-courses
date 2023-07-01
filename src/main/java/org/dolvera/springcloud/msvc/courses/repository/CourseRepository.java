package org.dolvera.springcloud.msvc.courses.repository;

import org.dolvera.springcloud.msvc.courses.models.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
