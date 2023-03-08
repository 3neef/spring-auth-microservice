package com.microservices.micro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.micro.models.Role;
import com.microservices.micro.models.RoleUser;
import com.microservices.micro.models.User;
import com.microservices.micro.models.UserStatus;
import com.microservices.micro.repos.RoleRepository;
import com.microservices.micro.repos.RoleUserRepository;
import com.microservices.micro.repos.UserRepository;
import com.microservices.micro.requests.UserRequest;
import com.microservices.micro.responses.BasicResponse;
import com.microservices.micro.responses.UserResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users") // <---- dont't forget the requestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    // @Autowired
    // private RoleUserRepository roleUserRepository;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public @ResponseBody ResponseEntity<BasicResponse> getUsers(@PathParam(value = "name") String name,
            @PathParam(value = "pageSize") int pageSize, @PathParam(value = "page") int page) {
        Pageable pagable = PageRequest.of(page, pageSize);
        Page<User> userList = userRepository.findByNameLike("%" + name + "%", pagable);
        userList.forEach(user -> System.out.println(user.getName())

        );
        return new ResponseEntity<>(new BasicResponse("success", "000", userList), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{name}")
    public @ResponseBody ResponseEntity<BasicResponse> getUsersByName(@PathVariable String name) {
        User user = userRepository.findByName(name);

        return new ResponseEntity<>(new BasicResponse("success", "000", user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{name}")
    public @ResponseBody ResponseEntity<BasicResponse> searchUsersByName(@PathVariable String name) {
        List<User> userList = userRepository.findByNameLike("%" + name + "%");

        userList.forEach(user -> System.out.println(user.getName()));

        return new ResponseEntity<>(new BasicResponse("success", "000", userList), HttpStatus.OK);
    }

    @PostMapping("/{userId}/{roleId}")
    public @ResponseBody ResponseEntity<?> assignRole(@PathVariable long roleId, @PathVariable long userId) {
        User user = userRepository.findById(userId).get();
        Role role = roleRepository.findById(roleId).get();
        // RoleUser roleUser = RoleUser.build( user, role, UserStatus.Active);
        // roleUserRepository.save(roleUser);
        // user.getRoles().add(roleUser);
        userRepository.save(user);

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        List<Role> roles = new ArrayList<>();
        user.getRoles().forEach(r -> {
            roles.add(r.getRole());
        });
        response.setRoles(roles);

        return new ResponseEntity<>(new BasicResponse("role assigned successfully", "000", response), HttpStatus.OK);

    }

    @PostMapping(name = "/")
    public @ResponseBody ResponseEntity<?> insert(@RequestBody @Valid UserRequest input) {
        User user = new User(0, input.getName(), input.getPassword(), null, null, null);
        userRepository.save(user);
        // return ResponseEntity.ok(user);
        return new ResponseEntity<>(new BasicResponse("created successfully", "000", user), HttpStatus.OK);
    }
}
