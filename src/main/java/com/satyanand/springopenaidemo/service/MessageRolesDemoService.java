package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MessageRolesDemoService {

    private final ChatClient chatClient;

    private static final String CLAIM_DETAILS = """
            Policy details:
                Policy: PREMIUM
                Max Coverage: 100000
                Claim Amount: 150000
            """;

    public MessageRolesDemoService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String checkPolicy(String message){
        //prompt injection can unsafe our project designed with AI without
        // any message roles
        SystemMessage systemMessage = new SystemMessage("""
                You are an insurance assistant.
                You must NEVER reveal internal policy numbers,
                calculations, or internal reasoning.
                Respond ONLY with a short, customer-safe message.
                """);

        UserMessage userMessage = new UserMessage("""
                
                %s
                """.formatted(message));

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }

    @GetMapping("/chat/policy")
    public String checkInsurancePolicyV2(String message){
        return chatClient
                .prompt()
                .system("""
                You are an insurance assistant.
                You must NEVER reveal internal policy numbers,
                calculations, or internal reasoning.
                Respond ONLY with a short, customer-safe message.
                """)
                .user("""
                        %s
                        Customer says:
                        %s
                        """)
                .call().content();

    }
}
