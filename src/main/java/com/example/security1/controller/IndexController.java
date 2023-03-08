package com.example.security1.controller;

import com.example.security1.dto.UserDto;
import com.example.security1.service.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final IndexService indexService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // localhost:8080/
    // localhost:8080
    @GetMapping({"", "/"})
    public String index() {
        // (Spring 에서 권장하는 template engine) Mustache - 기본 폴더 : src/main/resources
        // View Resolver 설정 : templates (prefix), .mustache (suffix) - Mustache 사용 시 생략 가능
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(UserDto dto) {
        log.info("UserDto : {}", dto);
        dto.setRole("ROLE_USER");

        String rawPassword = dto.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
        dto.setPassword(encodePassword);
        log.info("encodedPassword : {}", dto.getPassword());

        indexService.join(dto);

        return "redirect:/loginForm";
    }

}
