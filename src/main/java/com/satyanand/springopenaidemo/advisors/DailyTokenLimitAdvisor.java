package com.satyanand.springopenaidemo.advisors;

import com.satyanand.springopenaidemo.service.DailyTokenUsageService;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.model.ChatResponse;

public class DailyTokenLimitAdvisor implements CallAdvisor {

    private static final int DAILY_LIMIT = 2000;

    private final DailyTokenUsageService tokenUsageService;

    public DailyTokenLimitAdvisor(DailyTokenUsageService tokenUsageService) {
        this.tokenUsageService = tokenUsageService;
    }

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {

        // Get user id
        String userId = "user1";

        int usedTokens = tokenUsageService.getUsedTokens(userId);

        if (usedTokens >= DAILY_LIMIT) {
            throw new RuntimeException(
                    "Daily token limit of 2000 exceeded. Please try again tomorrow."
            );
        }

        // Continue to LLM
        ChatClientResponse response = callAdvisorChain.nextCall(chatClientRequest);

        ChatResponse chatResponse = response.chatResponse();

        if (chatResponse != null) {

            int totalTokens = chatResponse.getMetadata()
                    .getUsage()
                    .getTotalTokens();

            tokenUsageService.addTokens(userId, totalTokens);
        }

        return response;
    }

    @Override
    public String getName() {
        return "DailyTokenLimitAdvisor";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
