package com.student.StudentManagemenetSystem.Service;


import com.student.StudentManagemenetSystem.Dto.MessageDTO;

public interface MessageService {
    String sendMessage(MessageDTO messageDTO);
}
