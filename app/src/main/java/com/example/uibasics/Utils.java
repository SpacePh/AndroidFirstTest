package com.example.uibasics;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static Utils instance;

    private static List<Book> allBooks;
    private static List<Book> alreadyReadBooks;
    private static List<Book> wantToReadBooks;
    private static List<Book> currentlyReadingBooks;
    private static List<Book> favoriteBooks;

    private Utils() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (alreadyReadBooks == null) alreadyReadBooks = new ArrayList<>();
        if (wantToReadBooks == null) wantToReadBooks = new ArrayList<>();
        if (currentlyReadingBooks == null) currentlyReadingBooks = new ArrayList<>();
        if (favoriteBooks == null) favoriteBooks = new ArrayList<>();
    }

    private void initData() {
        // TODO: add initial data
        allBooks.add(new Book(1, "1Q84", "Haruki Murakami", 1350, "https://upload.wikimedia.org/wikipedia/pt/a/a6/1Q84.jpg", "A work of maddening brilliance", "Long Description"));
        allBooks.add(new Book(2, "The Myth of Sisyphus", "Albert Camus", 250, "https://upload.wikimedia.org/wikipedia/en/7/75/Le_Mythe_de_Sisyphe.jpg", "One of the most influential works of this century, The Myth of Sisyphus and Other Essays is a crucial exposition of existentialist thought.", "Long Description"));

    }

    public static Utils getInstance() {
        if (instance == null) instance = new Utils();
        return instance;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public List<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public List<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public List<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead(Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addToCurrentlyReading(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addToFavorite(Book book) {
        return favoriteBooks.add(book);
    }
}
