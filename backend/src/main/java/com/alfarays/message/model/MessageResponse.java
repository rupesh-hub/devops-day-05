package com.alfarays.message.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

    private Long id;
    private String content;
    private String createdBy;
    private String createdOn;
    private String modifiedBy;
    private String modifiedOn;

}
