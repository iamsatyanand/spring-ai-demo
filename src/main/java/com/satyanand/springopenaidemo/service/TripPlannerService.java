package com.satyanand.springopenaidemo.service;

import com.satyanand.springopenaidemo.dto.TripPlan;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripPlannerService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/trip-guide-template.st")
    private Resource tripGuideTemplate;

    public TripPlannerService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public TripPlan getTripPlans(String message){
        return chatClient
                .prompt()
                .system(tripGuideTemplate)
                .user(message)
                .call()
                .entity(TripPlan.class);
    }
}
