package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.MessageDTO;
import com.student.StudentManagemenetSystem.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whatsapp")
public class MessageController {

    @Autowired
    MessageService messageService;


    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        try {
            String response = messageService.sendMessage(messageDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while sending the message.");
        }
    }
}
