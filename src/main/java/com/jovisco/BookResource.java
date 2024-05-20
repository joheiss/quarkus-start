package com.jovisco;

import java.util.List;
import java.util.Optional;

import com.jovisco.domain.Book;
import com.jovisco.dtos.BookDto;
import com.jovisco.mappers.BookMapper;
import com.jovisco.repositories.BookRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject 
    BookMapper bookMapper;
    
    @GET
    public List<BookDto> getAll() {
        log.info("*** get all books SLF4J");
        return bookRepository.getBooks()
            .stream()
            .map(bookMapper::toDto)
            .toList();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAll() {
        return bookRepository.getBooks().size();
    }

    @GET
    @Path("{id}")
    public BookDto getById(@PathParam("id") int id) {
        return bookMapper.toDto(bookRepository.getBook(id).orElse(null));
    }
}
