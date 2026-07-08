package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SystemRoleViaConfigService {

    private final ChatClient chatClient;

    public SystemRoleViaConfigService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    private static final String CLAIM_DETAILS = """
            Policy details:
                Policy: PREMIUM
                Max Coverage: 100000
                Claim Amount: 150000
            """;

    public String checkInsurancePolicyV3(String message){
        return chatClient
                .prompt()
                .user("""
                        %s
                        Customer says:
                        %s
                        """.formatted(CLAIM_DETAILS, message))
                .call().content();

    }
    public ChatResponse checkInsurancePolicyV4(String message){
        return chatClient
                .prompt()
                .user("""
                        %s
                        Customer says:
                        %s
                        """.formatted(CLAIM_DETAILS, message))
                .call().chatResponse();

    }
}
