package org.example;

import java.time.LocalDate;

public class Book extends Model{
    private String language;
    private LocalDate publicationDate;
    private int numberOfPages;
    private String title;

    public Book() {
    }

    public Book(String title, String language, LocalDate publicationDate, int numberOfPages) {
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


}
