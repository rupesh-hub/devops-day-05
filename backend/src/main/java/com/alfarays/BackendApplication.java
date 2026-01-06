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
    public ApplicationRunner applicationRunner(MessageRepository messageRepository) {
        return args -> {
            // Only seed data if the database is empty to avoid duplicates on every restart
            if (messageRepository.count() == 0) {
                java.util.stream.IntStream.rangeClosed(1, 10).forEach(i -> {
                    messageRepository.save(
                            Message.builder()
                                    .content("Message #" + i + ": Welcome to devops practice [MySql, Thymeleaf 2-tier application]")
                                    .build()
                    );
                });
                System.out.println(">> Database seeded with 10 practice messages.");
            }
        };
    }
}
