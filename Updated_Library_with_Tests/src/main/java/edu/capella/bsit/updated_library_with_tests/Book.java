package edu.capella.bsit.updated_library_with_tests;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class Book {
    private String title;
    private String author;
    private String description;

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        String subtitle = null;
        return subtitle;
    }

    @Override
    public String toString() {
        return author + ": " + title + " " + subtitle;
    }
}
