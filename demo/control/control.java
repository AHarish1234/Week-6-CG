package com.example.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {

    @GetMapping("/World ")
    public String hello(){
        return "Hello world";
    }

    @PostMapping("/add")
    public String add(){
        return "data added succesfully";
    }
    
    @PutMapping("/update")
    public String update() {
    	return "data updated successfully";
    }
    
    @DeleteMapping("/delete")
    public String delete() {
    	return "data deleted successfully";
    }
}
