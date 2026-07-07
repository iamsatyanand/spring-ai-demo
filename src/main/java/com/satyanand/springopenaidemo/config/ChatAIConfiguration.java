package com.satyanand.springopenaidemo.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAIConfiguration {

    @Bean
    public ChatClient openAIChatClient(OpenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

    @Bean
    public ChatClient ollamaChatClient(OllamaChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

    @Bean
    public ChatClient genaiChatModel(GoogleGenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

}
