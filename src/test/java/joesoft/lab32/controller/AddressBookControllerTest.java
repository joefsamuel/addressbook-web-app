package joesoft.lab32.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressBookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addBuddyInfoAPI() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/newbook")).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/api/addbuddy?name=joe&phone=232323&address=1233 Colonel").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"joe\",\"phoneNumber\":\"232323\",\"address\":\"1233 Colonel\"}")));
    }

    @Test
    void greeting() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
}