package com.satyanand.springopenaidemo.controller;

import com.satyanand.springopenaidemo.service.MessageRolesDemoService;
import com.satyanand.springopenaidemo.service.OpenAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")

public class OpenAiChatController {
    private final OpenAIChatService chatService;
    private final MessageRolesDemoService messageRolesDemoService;

    public OpenAiChatController(OpenAIChatService chatService, MessageRolesDemoService messageRolesDemoService) {
        this.chatService = chatService;
        this.messageRolesDemoService = messageRolesDemoService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
        System.out.println(message);
        return chatService.chatWithOpenAiLLM(message);
    }

    @GetMapping("/check-policy")
    public String checkInsurancePolicy(@RequestParam("message") String message){
        return messageRolesDemoService.checkPolicy(message);
    }
}
