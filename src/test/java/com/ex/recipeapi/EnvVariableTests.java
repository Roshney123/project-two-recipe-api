package com.ex.recipeapi;

import org.junit.jupiter.api.Test;

public class EnvVariableTests {

    @Test
    public void shouldOutPutEmailApiURL() {
        String emailApiUrl = System.getenv("EMAIL_API_URL");
        System.out.println("emailApiUrl: " + emailApiUrl);
    }
}
