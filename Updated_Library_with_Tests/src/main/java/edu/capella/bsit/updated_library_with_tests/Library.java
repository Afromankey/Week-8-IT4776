package edu.capella.bsit.updated_library_with_tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }
    
    public List<String> describeBooksBy(String author) {
        return this.books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(book -> book.toString())
                .collect(Collectors.toList());
    }
}
