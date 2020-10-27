package eu.miaplatform.customplugin.springboot.springboot.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void withoutUserId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"message\":\"Hello world!\"}"));
    }

    @Test
    public void withUserId() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/hello")
                        .header("USERID_HEADER_KEY", "john.doe")
        )
            .andExpect(status().isOk())
            .andExpect(content().json("{\"message\":\"Hello john.doe!\"}"));
    }

    @Test
    public void defaultReadinessRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/ready"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}")
        );
    }

    @Test
    public void defaultLivenessRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/healthz"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}")
        );
    }

    @Test
    public void defaultCheckUpRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/check-up"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}")
        );
    }
}
