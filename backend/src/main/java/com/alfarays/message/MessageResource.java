package com.alfarays.message;

import com.alfarays.message.model.MessageResponse;
import com.alfarays.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageResource {

    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageResponse>> messages() {
        return ResponseEntity.ok(messageService.messages());
    }
}
