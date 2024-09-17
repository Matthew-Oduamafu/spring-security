package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.AppUserRepository;
import com.luv2code.springboot.cruddemo.dao.AuthorityRepository;
import com.luv2code.springboot.cruddemo.entity.AppUser;
import com.luv2code.springboot.cruddemo.entity.Authority;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    private final AppUserRepository appUserRepository;
    private final AuthorityRepository authorityRepository;

    public AppUserController(AppUserRepository appUserRepository, AuthorityRepository authorityRepository) {
        this.appUserRepository = appUserRepository;
        this.authorityRepository = authorityRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser saveUser(@RequestBody AppUser appUser) {
        var user = appUserRepository.save(appUser);
        authorityRepository.save(new Authority(user.getUsername(), "ROLE_EMPLOYEE"));
        return user;
    }
}
