package com.spring.api.controller;


import com.spring.api.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    public void testCreateDepartment() throws Exception{
        mockMvc.perform(post("/departments").contentType("application/json")
                .content("{\"departmentName\":\"ECE\",\"departmentAddress\":\"BLOCK-4\",\"departmentCode\":\"104\"}"))
                .andExpect(status().isCreated());
    }

}
