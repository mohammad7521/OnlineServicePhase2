package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.request.addUpdate.ExpertSave;
import com.example.onlineServiceProvider.entity.user.Expert;
import com.example.onlineServiceProvider.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/expert")
public class ExpertController {


    private UserService userService;
    private ModelMapper modelMapper;

    public ExpertController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> save(ExpertSave expertSave){
        Expert expert=modelMapper.map(expertSave,Expert.class);
        userService.add(expert);
        return ResponseEntity.ok("verification code sent");
    }

}
