package com.alfarays.message.service;

import com.alfarays.message.mapper.MessageMapper;
import com.alfarays.message.model.MessageResponse;
import com.alfarays.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageResponse messageById(final Long id) {
        return messageRepository.findById(id)
                .map(MessageMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("No resource found !"));
    }

}
