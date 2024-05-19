package com.jovisco.repositories;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.jovisco.domain.Book;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "English Literature")
    String genre;
    /**
     * Generate test data for books
     * @return a list of books
     */
    public List<Book> getBooks() {
        return List.of(
            Book.builder()
                .id(1)
                .title("Understanding Quarkus")
                .author("Antonio Goncalves")
                .genre(genre)
                .yearOfPublication(2020)
                .build(),
            Book.builder()
                .id(2)
                .title("Practising Quarkus")
                .author("Antonio Goncalves")
                .genre(genre)
                .yearOfPublication(2020)
                .build(),
            Book.builder()
                .id(3)
                .title("Effective Java")
                .author("Josh Bloch")
                .genre(genre)
                .yearOfPublication(2001)
                .build(),
            Book.builder()
                .id(4)
                .title("Thinking in Java")
                .author("Bruce Eckel")
                .genre(genre)
                .yearOfPublication(1998)
                .build()
        );
    }

    /**
     * 
     * @param book id
     * @return a single book for the given id
     */
    public Optional<Book> getBook(int id) {
        return getBooks()
            .stream()
            .filter(book -> book.id == id)
            .findFirst();
    }
}

