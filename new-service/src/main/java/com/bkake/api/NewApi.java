package com.bkake.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewApi {

    @GetMapping(value = "/")
    public String news() {
        return "I am the future functional entry point";
    }

}
