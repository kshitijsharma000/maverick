package com.desk.mainUI;

/**
 * Created by kshitij.sharma on 9/30/2015.
 */
public class Categories_list {
    private String Category;
    private Books books;

    private class Books {
        private String book_coverUrl;
        private String book_name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}

