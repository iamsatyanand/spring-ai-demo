package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripPlannerService {

    private final ChatClient chatClient;

    public TripPlannerService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public String getTripPlans(String message){
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
