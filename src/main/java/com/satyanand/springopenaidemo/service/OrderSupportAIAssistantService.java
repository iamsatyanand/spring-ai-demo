package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderSupportAIAssistantService {

    @Value("classpath:prompts/order_system_template.st")
    private Resource orderSystemPrompt;

    @Value("classpath:prompts/order_user_template.st")
    private Resource orderUserPrompt;

    private final ChatClient chatClient;

    public OrderSupportAIAssistantService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String assistWithOrderSupport(String customerName, String orderId, String customerMessage){
        return chatClient
                .prompt()
                .system(orderSystemPrompt)
                .user(text -> text.text(orderUserPrompt)
                        .param("customerName", customerName)
                        .param("orderId", orderId)
                        .param("customerMessage", customerMessage))
                .call()
                .content();
    }
}
