package com.alfarays.message.entity;

import com.alfarays.shared.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="_messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq_generator")
    @SequenceGenerator(name="message_id_seq_generator", sequenceName = "message_id_seq", allocationSize = 50, initialValue = 1)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String content;

}
