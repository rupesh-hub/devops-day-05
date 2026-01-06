package com.alfarays;

import com.alfarays.message.entity.Message;
import com.alfarays.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication {

    private final MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            messageRepository.save(
                    Message.builder()
                            .content("Welcome to devops practice [MySql, Thymeleaf 2-tier application]")
                            .build()
            );
        };
    }
}
