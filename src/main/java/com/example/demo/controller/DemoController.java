package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("prodapt-screening/app/v1")

public class DemoController {

    @GetMapping("/remove")
    public ResponseEntity<String> removeCharacter(@RequestParam String data){
        if(data.length()==2)
            return ResponseEntity.ok("");
        else if(data==null||data.length()<2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This is invalid string");
      String result=data.substring(1,data.length()-1);
            return ResponseEntity.ok(result);
    }

}
