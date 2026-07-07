package com.satyanand.springopenaidemo.controller;

import com.satyanand.springopenaidemo.service.MultiModelChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("multi-model/api")
public class MultiModelChatController {

    private final MultiModelChatService chatService;

    public MultiModelChatController(MultiModelChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/openai")
    public String chatWithOpenAI(String message){
        return chatService.chatWithOpenAI(message);
    }

    @GetMapping("/chat/ollama")
    public String chatWithOllama(String message){
        return chatService.chatWithOllama(message);
    }

    @GetMapping("/chat/google-genai")
    public String chatWithGoogleGenAI(String message){
        return chatService.chatWithGoogleGenAI(message);
    }

}
