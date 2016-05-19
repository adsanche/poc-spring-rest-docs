package com.capgemini.srd.web.controller;

import com.capgemini.srd.Application;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test/Documentation class for the user REST controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserControllerDocumentation {

    /**
     * Generated documentation target directory.
     */
    @Rule
    public RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

    /**
     * Application context.
     */
    @Autowired
    private WebApplicationContext context;

    /**
     * Mock MVC client.
     */
    private MockMvc mockMvc;

    /**
     * Mock MVC client initialization.
     */
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    /**
     * Test method for getDefaultUser.
     *
     * @throws Exception
     */
    @Test
    public void getDefaultUserTest() throws Exception {
        this.mockMvc.perform(get("/users/getDefaultUser").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("users",
                        requestHeaders(
                                headerWithName("Host").description("Request host.")
                        ),
                        responseFields(
                                fieldWithPath("id").description("User ID."),
                                fieldWithPath("login").description("User login."),
                                fieldWithPath("firstName").description("User first name."),
                                fieldWithPath("lastName").description("User last name."))));
    }
}