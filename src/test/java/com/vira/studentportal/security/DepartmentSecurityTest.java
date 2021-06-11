package com.vira.studentportal.security;

import com.studentportal.department.DepartmentRepo;
import com.studentportal.department.DepartmentService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class DepartmentSecurityTest {
    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @MockBean
    DepartmentRepo departmentRepo;

    @MockBean
    DepartmentService departmentService;

    @Before
    public void setUpBeans() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }
    @WithMockUser("spring")
    @Ignore
    @Test
    public void getDepartments() throws Exception {
        mockMvc.perform(get("/departments"))
                .andExpect(status().isOk());
    }
    @Test
    @Ignore
    public void getDepartmentsWithHttpBasic() throws Exception {
        mockMvc.perform(get("/departments").with(httpBasic("spring", "tatar")))
                .andExpect(status().isOk());
    }
}
