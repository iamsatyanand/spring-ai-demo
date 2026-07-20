package com.satyanand.springopenaidemo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DailyTokenUsageService {

    private static final int DAILY_LIMIT = 2000;

    private final Map<String, Integer> usageMap = new ConcurrentHashMap<>();

    public int getUsedTokens(String userId){
        return usageMap.getOrDefault(getKey(userId), 0);
    }

    public void addTokens(String userId, int tokens){
        String key = getKey(userId);
        usageMap.merge(key, tokens, (oldToken, newToken) -> oldToken + newToken);
    }

    public boolean isLimitExceeded(String userId){
        return getUsedTokens(userId) > DAILY_LIMIT;
    }

    private String getKey(String userId){
        return userId+"_"+ LocalDate.now();
    }

}
