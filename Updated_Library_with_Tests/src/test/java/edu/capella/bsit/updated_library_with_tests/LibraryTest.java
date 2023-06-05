/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.capella.bsit.updated_library_with_tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("author", "title", "isbn");
        assertTrue(library.addBook(book));
    }

    @Test
    public void testDescribeBooksByAuthorExists() {
        System.out.println("testDescribeBooksByAuthorExists");
        Iterable<String> iterable = (Iterable<String>) library.describeBooksBy("Author1");
        List<String> books = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        assertEquals(2, books.size());
        assertTrue(books.contains("Author1: Title1"));
        assertTrue(books.contains("Author1: Title3"));
    }

    @Test
    public void testDescribeBooksByAuthorDoesNotExist() {
        System.out.println("testDescribeBooksByAuthorDoesNotExist");
        Iterable<String> iterable = (Iterable<String>) library.describeBooksBy("Author3");
        List<String> books = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        assertTrue(books.isEmpty());
    }

    @Test
    public void testDescribeBooksByEmptyLibrary() {
        System.out.println("testDescribeBooksByEmptyLibrary");
        Library emptyLibrary = new Library();
        Iterable<String> iterable = (Iterable<String>) emptyLibrary.describeBooksBy("Author1");
        List<String> books = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        assertTrue(books.isEmpty());
    }
}
