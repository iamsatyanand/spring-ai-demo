package com.satyanand.springopenaidemo.controller;

import com.satyanand.springopenaidemo.service.MessageRolesDemoService;
import com.satyanand.springopenaidemo.service.OpenAIChatService;
import com.satyanand.springopenaidemo.service.SystemRoleViaConfigService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")

public class OpenAiChatController {
    private final OpenAIChatService chatService;
    private final MessageRolesDemoService messageRolesDemoService;
    private final SystemRoleViaConfigService systemRoleViaConfigService;

    public OpenAiChatController(OpenAIChatService chatService, MessageRolesDemoService messageRolesDemoService, SystemRoleViaConfigService systemRoleViaConfigService) {
        this.chatService = chatService;
        this.messageRolesDemoService = messageRolesDemoService;
        this.systemRoleViaConfigService = systemRoleViaConfigService;
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
    @GetMapping("/chat/policy")
    public String checkInsurancePolicyV2(@RequestParam("message") String message){
        return messageRolesDemoService.checkInsurancePolicyV2(message);
    }
    @GetMapping("/chat/policy-v3")
    public String checkInsurancePolicyV3(@RequestParam("message") String message){
        return systemRoleViaConfigService.checkInsurancePolicyV3(message);
    }
    @GetMapping("/chat/policy-v4")
    public ChatResponse checkInsurancePolicyV4(@RequestParam("message") String message){
        return systemRoleViaConfigService.checkInsurancePolicyV4(message);
    }
}
