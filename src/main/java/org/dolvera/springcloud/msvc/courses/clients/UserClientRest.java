package org.dolvera.springcloud.msvc.courses.clients;

import org.dolvera.springcloud.msvc.courses.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="msvc-users", url="localhost:8001")
public interface UserClientRest {

    @GetMapping("/byId/{id}")
    User byId(@PathVariable Long id);

    @PostMapping("/save")
    User create(@RequestBody User user);

}
