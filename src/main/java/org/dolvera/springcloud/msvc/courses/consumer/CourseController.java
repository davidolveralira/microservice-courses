package org.dolvera.springcloud.msvc.courses.consumer;

import org.dolvera.springcloud.msvc.courses.models.entity.Course;
import org.dolvera.springcloud.msvc.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/springcloud/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/obtain")
    public ResponseEntity<List<Course>> obtain() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id) {
        Optional<Course> o = service.byId(id);
        if (o.isPresent()) {
            return ResponseEntity.ok().body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course> o = service.byId(id);
        if (o.isPresent()) {
            Course courseDb = o.get();
            courseDb.setName(course.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> erase(@PathVariable Long id) {
        Optional<Course> o =service.byId(id);
        if (o.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
