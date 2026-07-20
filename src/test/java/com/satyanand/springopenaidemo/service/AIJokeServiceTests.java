package com.satyanand.springopenaidemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIJokeServiceTests {

    @Autowired
    private  AIJokeService jokeService;

    @Test
    public void testGetJoke(){
        var joke = jokeService.getJoke("programmers");
        System.out.println(joke);
    }
}
