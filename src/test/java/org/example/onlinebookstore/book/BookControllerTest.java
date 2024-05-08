package org.example.onlinebookstore.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.onlinebookstore.controller.BookController;
import org.example.onlinebookstore.entity.Book;
import org.example.onlinebookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = BookController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @MockBean
    private BookRepository repository;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void shouldReturnABook() throws Exception {
        Book book = new Book(1, "To Kill a Mockingbird", "Harper Lee", 1960);
        Mockito.doReturn(Optional.of(book)).when(repository).findById(1);

        final String expectedResponseContent = objectMapper.writeValueAsString(book);
        this.mvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseContent));
    }

    @Test
    void shouldCreateABook() throws Exception {
        Book book = new Book(69, "To kill a DockingBird", "Harper Gee", 1969);

        final String uploadContent = objectMapper.writeValueAsString(book);
        this.mvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(uploadContent))
                .andExpect(status().isCreated());
    }


}