package com.example.uibasics;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";

    private static Utils instance;

    private SharedPreferences sharedPreferences;

    private static List<Book> allBooks;
    private static List<Book> alreadyReadBooks;
    private static List<Book> wantToReadBooks;
    private static List<Book> currentlyReadingBooks;
    private static List<Book> favoriteBooks;

    private Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);
        if (getAllBooks() == null) initData();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getAlreadyReadBooks() == null) {
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (getWantToReadBooks() == null) {
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (getCurrentlyReadingBooks() == null) {
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (favoriteBooks == null) {
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        // TODO: add initial data

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "1Q84", "Haruki Murakami", 1350, "https://upload.wikimedia.org/wikipedia/pt/a/a6/1Q84.jpg", "A work of maddening brilliance", "Long Description"));
        books.add(new Book(2, "The Myth of Sisyphus", "Albert Camus", 250, "https://upload.wikimedia.org/wikipedia/en/7/75/Le_Mythe_de_Sisyphe.jpg", "One of the most influential works of this century, The Myth of Sisyphus and Other Essays is a crucial exposition of existentialist thought.", "Long Description"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (instance == null) instance = new Utils(context);
        return instance;
    }

    public List<Book> getAllBooks() {
        return getFromSharedPreferences(ALL_BOOKS_KEY);
    }

    public List<Book> getAlreadyReadBooks() {
        return getFromSharedPreferences(ALREADY_READ_BOOKS);
    }

    public List<Book> getWantToReadBooks() {
        return getFromSharedPreferences(WANT_TO_READ_BOOKS);
    }

    public List<Book> getCurrentlyReadingBooks() {
        return getFromSharedPreferences(CURRENTLY_READING_BOOKS);
    }

    public List<Book> getFavoriteBooks() {
        return getFromSharedPreferences(FAVORITE_BOOKS);
    }

    private List<Book> getFromSharedPreferences(String key){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Book>>() {}.getType();
        List<Book> books = gson.fromJson(sharedPreferences.getString(key, null), type);
        return books;
    }

    public Book getBookById(int id) {
        List<Book> books = getAllBooks();
        if(books != null) {
            for (Book b : books) {
                if (b.getId() == id)
                    return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return addToList(getAlreadyReadBooks(), book, ALREADY_READ_BOOKS);
    }

    public boolean addToWantToRead(Book book) {
        return addToList(getWantToReadBooks(), book, WANT_TO_READ_BOOKS);
    }

    public boolean addToCurrentlyReading(Book book) {
        return addToList(getCurrentlyReadingBooks(), book, CURRENTLY_READING_BOOKS);
    }

    public boolean addToFavorite(Book book) {
        return addToList(getFavoriteBooks(), book, CURRENTLY_READING_BOOKS);
    }

    private boolean addToList(List<Book> books, Book book, String key) {
        if(books != null) {
            if(books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(key);
                editor.putString(key, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book) {
        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromWantToRead(Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean removeFromCurrentlyReading(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeFromFavorites(Book book) {
        return favoriteBooks.remove(book);
    }
}
