package org.dolvera.springcloud.msvc.courses.services;

import org.dolvera.springcloud.msvc.courses.models.User;
import org.dolvera.springcloud.msvc.courses.models.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();
    Optional<Course> byId(Long id);
    Course save(Course course);
    void delete(Long id);

    /* Data obtained from another microservice: msvc-users
     Remote methods, related to the http client*/
    Optional<User> assignUser(User user, Long courseId);
    Optional<User> createUser(User user, Long courseId);
    Optional<User> deleteUser(User user, Long courseId);

}
