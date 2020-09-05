package com.example.uibasics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Margot Robbie", "Marot@gmail.com", "https://www.vogue.pt/media/gallery/voguept-margot-robbie-beleza19.jpg"));
        contacts.add(new Contact("Cillian Murphy", "Cillian@gmail.com", "https://br.web.img3.acsta.net/pictures/16/06/21/15/49/106729.jpg"));
        contacts.add(new Contact("Saiorse Ronan", "Saoirse@gmail.com", "https://m.media-amazon.com/images/M/MV5BMjExNTM5NDE4NV5BMl5BanBnXkFtZTcwNzczMzEzOQ@@._V1_.jpg"));
        contacts.add(new Contact("Emma Watson", "Emma@gmail.com", "https://i.pinimg.com/originals/80/19/16/8019160c1a40d202e8fa4f304cfb1459.png"));
        contacts.add(new Contact("Cristian Bale", "Cristial@gmail.com", "https://i.pinimg.com/originals/4c/c6/f1/4cc6f1f365fce288fcae170fa17b6875.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
//        contactsRecView.setLayoutManager(new LinearLayoutManager(this));
//        contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }

}