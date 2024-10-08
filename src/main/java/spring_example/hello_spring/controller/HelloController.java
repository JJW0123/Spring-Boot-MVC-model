package spring_example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam("name") String name01, Model model) {
        model.addAttribute("name", name01);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("string") String one) {
        return "hello " + one;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name01) {
        Hello hello = new Hello();
        hello.setName(name01);
        return hello;
    }

    @Getter
    @Setter
    static class Hello {
        private String name;
    }
}