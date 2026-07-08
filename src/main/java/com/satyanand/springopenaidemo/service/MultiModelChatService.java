package com.satyanand.springopenaidemo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class MultiModelChatService {

//    private final ChatClient openAIChatClient;
//    private final ChatClient ollamaChatClient;
//    private final ChatClient genaiChatModel;
//
//
//    public MultiModelChatService(ChatClient openAIChatClient, ChatClient ollamaChatClient, ChatClient genaiChatModel) {
//        this.openAIChatClient = openAIChatClient;
//        this.ollamaChatClient = ollamaChatClient;
//        this.genaiChatModel = genaiChatModel;
//    }
//
//    public String chatWithOpenAI(String message){
//        return openAIChatClient
//                .prompt(message)
//                .call()
//                .content();
//    }
//
//    public String chatWithOllama(String message){
//        return ollamaChatClient
//                .prompt(message)
//                .call()
//                .content();
//    }
//
//    public String chatWithGoogleGenAI(String message){
//        return genaiChatModel
//                .prompt(message)
//                .call()
//                .content();
//    }

}
