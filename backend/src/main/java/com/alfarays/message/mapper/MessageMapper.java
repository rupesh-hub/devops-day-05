package com.alfarays.message.mapper;

import com.alfarays.message.entity.Message;
import com.alfarays.message.model.MessageResponse;

public final class MessageMapper {

    private MessageMapper() {
    }

    public static MessageResponse toResponse(Message message) {
        return MessageResponse
                .builder()
                .id(message.getId())
                .content(message.getContent())
                .createdBy(message.getCreatedBy())
                .createdOn(message.getCreatedOn().toString())
                .modifiedBy(message.getModifiedBy())
                .modifiedOn(message.getModifiedOn().toString())
                .build();
    }

}
