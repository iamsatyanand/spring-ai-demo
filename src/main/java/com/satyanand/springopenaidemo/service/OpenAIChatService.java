package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAIChatService {

    private final ChatClient chatClient;

    public OpenAIChatService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public String chatWithOpenAiLLM(String message){

        ChatOptions chatOptions = ChatOptions.builder()
//                .model("gpt-4o-mini")
                .model("gemini-3.5-flash")
                .temperature(0.3)
                .maxTokens(100)
//                .frequencyPenalty(0.7)
//                .presencePenalty(0.7)
                .stopSequences(List.of("}"))
                .topK(50)
                .topP(0.5)
                .build();

        return chatClient
                .prompt(message)
                .options(chatOptions.mutate())
                .call()
                .content();
    }
}
