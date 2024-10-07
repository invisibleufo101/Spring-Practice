package org.zerock.ex00.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.SampleDTO;
import org.zerock.ex00.domain.SampleDTOList;
import org.zerock.ex00.domain.TodoDTO;

import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping(value="/sample")
public class SampleController {

    // So basically what I understand here is that the RequestMapping annotation only sets the general direction of the request routes (narrowed down to /sample)
    // So, now each method in this controller class only has the specify which SPECIFIC route they are receiving the requests from.
    // BUT THIS DOES NOT APPLY TO VIEWS. As you can see in ex02Array() method, we have to specify the general route of the view route ("sample/ex02")
    @GetMapping("/basic")
    public void basic() {
        log.info("basic\n----------------");
    }

    // GET Method
    // localhost:8090?name=ABC&age=20
    // Since SampleDTO has name and age as its fields,
    // if we put DTO class as a parameter, these query strings are automatically injects as the DTO object's field
    @GetMapping("/ex01")
    public void ex01(SampleDTO sampleDTO){
        log.info("ex01\n-----------------");
        log.info(sampleDTO);
    }

    // GET Method
    //
    @GetMapping("/ex02")
    public void ex02(
            @RequestParam("name") String name,
            @RequestParam(
                    value = "age",
                    required = false,
                    defaultValue = "10"
            ) int age
    ){
        log.info("ex02\n-------------------");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex02Array")
    public String ex02Array(String[] ids){
        log.info("ex02Array\n---------------");
        log.info(Arrays.toString(ids));
        return "/sample/ex02";
    }

    @GetMapping("/ex02Bean")
    public void ex02Bean(SampleDTOList sampleDTOList){
        log.info("ex02Bean\n---------------");
        log.info(sampleDTOList);
    }

    @GetMapping("/ex03")
    public void ex03(TodoDTO todoDTO){
        log.info("ex03\n-------------------");
        log.info("Todo: " + todoDTO);
    }

    // Route model binding
    // "/page/{blogPostId}"
    @GetMapping("/ex04")
    public void ex04(
            @ModelAttribute("dto") SampleDTO dto,
            @ModelAttribute("page") int page,
            Model model
    ){
        model.addAttribute("list", new String[]{"AAA", "BBB", "CCC"});

        log.info("ex04\n------------");
    }

    @GetMapping("/ex05")
    public String ex05(RedirectAttributes rttr){
        rttr.addAttribute("value1", "ABCDE");
        rttr.addAttribute("value2", "XYZ");

        // Flash -> Only happens once on the initial call. Won't stick around in the next subsequent calls
        rttr.addFlashAttribute("flashValue1", "ABCDE");
        rttr.addFlashAttribute("flashValue2", "XYZ");

        return "redirect:/sample/basic";
    }
}
