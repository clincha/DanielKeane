package com.DanielKeane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerAliveTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeAliveTest() throws Exception {
        mockMvc.perform(get("/home")).andExpect(status().isOk());
    }

    @Test
    public void aboutAliveTest() throws Exception {
        mockMvc.perform(get("/about")).andExpect(status().isOk());
    }

    @Test
    public void donationsAliveTest() throws Exception {
        mockMvc.perform(get("/donations")).andExpect(status().isOk());
    }

    @Test
    public void gigsAliveTest() throws Exception {
        mockMvc.perform(get("/gigs")).andExpect(status().isOk());
    }

    @Test
    public void releasesAliveTest() throws Exception {
        mockMvc.perform(get("/releases")).andExpect(status().isOk());
    }
}
