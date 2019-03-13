package com.supe.bassey.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editCountry;
    Button button;
    Spinner spinner;

    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtists = FirebaseDatabase.getInstance().getReference("artist");


        editText=(EditText) findViewById(R.id.AddName);
        editCountry=(EditText) findViewById(R.id.Country);
        button=(Button) findViewById(R.id.buttonAddArtist);
        spinner= (Spinner) findViewById(R.id.spinnerGenres);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addArtist();

            }
        });
    }

    private void addArtist(){
        String name= editText.getText().toString().trim();
        String genre = spinner.getSelectedItem().toString();
        String country = editCountry.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){
            String id =databaseArtists.push().getKey();

            Artist artist= new Artist(id, name, genre, country);

            databaseArtists.child(id).setValue(artist);

            Toast.makeText(this,"Artist added", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(this, "you should enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
