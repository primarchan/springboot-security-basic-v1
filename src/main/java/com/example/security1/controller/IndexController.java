package com.example.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // localhost:8080/
    // localhost:8080
    @GetMapping({"", "/"})
    public String index() {
        // (Spring 에서 권장하는 template engine) Mustache - 기본 폴더 : src/main/resources
        // View Resolver 설정 : templates (prefix), .mustache (suffix) - Mustache 사용 시 생략 가능
        return "index";
    }

}
