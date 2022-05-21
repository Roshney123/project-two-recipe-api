package com.ex.recipeapi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvVarTest {

    Logger logger = LoggerFactory.getLogger(EnvVarTest.class);

    @Test
    public void shouldOutPutEmailApiURL() {
        String emailApiUrl = System.getenv("EMAIL_API_URL");
        System.out.println("emailApiUrl: " + emailApiUrl);
    }
}
