package br.com.alexjr.listviewexample;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alice", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Bob", R.drawable.ic_launcher_foreground));

        ContactAdapter adapter = new ContactAdapter(this, contacts);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contacts.get(position);
                Toast.makeText(MainActivity.this, "Selected: " + selectedContact.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
