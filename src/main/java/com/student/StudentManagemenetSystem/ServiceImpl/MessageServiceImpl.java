package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.MessageDTO;
import com.student.StudentManagemenetSystem.Entity.MessageEntity;
import com.student.StudentManagemenetSystem.Repository.Repository.MessageRepository;
import com.student.StudentManagemenetSystem.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public String sendMessage(MessageDTO messageDTO) {
        try {

            MessageEntity messageEntity = new MessageEntity(messageDTO);

            MessageEntity save = messageRepository.save(messageEntity);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://graph.facebook.com/v13.0/" + messageDTO.getPhoneNumberId() + "/messages"))
                    .header("Authorization", "Bearer EAAN5G2mjP1YBO5YvHed3cy16tngUfxPYEEeQQQh7rqpWuEgcmXlBMZA7QZApsMdqdCf6ijpfftZBWdZCodUw78yj9my0nf3riwTUJLVZApfBZBGaa9ThBdguMPa8uEj8RTCvFT6glbNFKwnZB40QEFS9vjU7vQ73MxnVxFfja8hdBcLctO4g0wgSmqSebNzVM2aAnL04tdMEgSFuZCSftsIZD" )
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"messaging_product\": \"whatsapp\",\"recipient_type\": \"individual\", \"to\": \"" + messageDTO.getTargetPhoneNumber() + "\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\":\"" + messageDTO.getMessage() + "\" } }"))
                    .build();
            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());


            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while sending the message.";
        }
    }

}
