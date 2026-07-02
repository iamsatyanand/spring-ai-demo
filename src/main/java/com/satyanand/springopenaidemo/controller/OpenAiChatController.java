package com.satyanand.springopenaidemo.controller;

import com.satyanand.springopenaidemo.service.OpenAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")

public class OpenAiChatController {
    private final OpenAIChatService chatService;

    public OpenAiChatController(OpenAIChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chat(String message){
        System.out.println(message);
        return chatService.chatWithOpenAiLLM(message);
    }
}
