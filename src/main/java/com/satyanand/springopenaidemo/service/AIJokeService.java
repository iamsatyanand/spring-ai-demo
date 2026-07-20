package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AIJokeService {

    private final ChatClient chatClient;

    public AIJokeService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getJoke(String topic){
        String systemPrompt = """
                You are a sarcastic joker, you make poetic joke in 4 lines.
                You don't make joke about politics.
                Give a joke on the topic : {topic}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String renderedText = promptTemplate.render(Map.of("topic", topic));

        return chatClient.prompt()
                .user(renderedText)
                .call()
                .content();
    }
}
