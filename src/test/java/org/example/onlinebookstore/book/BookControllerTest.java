package org.example.onlinebookstore.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BookRepository bookRepository;


    @Test
    @WithMockUser(roles="ADMIN")
    public void ShouldRun() throws Exception {

        MvcResult result = mvc.perform(get("/api/books/1")).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

}