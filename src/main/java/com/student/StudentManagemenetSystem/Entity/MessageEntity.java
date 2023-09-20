package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private String message;

    public MessageEntity(MessageDTO messageDTO) {
        this.phoneNumber=messageDTO.getTargetPhoneNumber();
        this.message=messageDTO.getMessage();
    }
}
