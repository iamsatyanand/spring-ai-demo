package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class MessageRolesDemoService {

    private final ChatClient chatClient;

    public MessageRolesDemoService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String checkPolicy(String message){
        //prompt injection can unsafe our project designed with AI without
        // any message roles
        UserMessage userMessage = new UserMessage("""
                Policy details:
                Policy: PREMIUM
                Max Coverage: 100000
                Claim Amount: 150000
                Customer says:
                %s
                """.formatted(message));

        Prompt prompt = new Prompt(userMessage);

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
