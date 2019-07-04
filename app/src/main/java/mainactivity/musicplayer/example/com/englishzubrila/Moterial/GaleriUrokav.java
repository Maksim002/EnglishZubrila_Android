package mainactivity.musicplayer.example.com.englishzubrila.Moterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.InitialСourse.Initialcourse;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class GaleriUrokav extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materials_of_subjects);


        RecyclerView recyclerView = findViewById(R.id.listMaterialsRecyclerView);
        recyclerView.setAdapter(new Adaptor(this, getContact()));

        Adaptor adaptor = new Adaptor(this, getContact());
    }

    List<Contact> getContact() {
        List<Contact> contact = new ArrayList<>();
        contact.add(new Contact("", "Initial course"));
        contact.add(new Contact("", "B разработке"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        contact.add(new Contact("", "В разработек"));
        return contact;
    }

    @Override
    public void onClikGaleri(int position) {
        switch (position){
            case 0:
                Toast.makeText(getApplicationContext(), "Position 0", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GaleriUrokav.this, Initialcourse.class);
                startActivity(intent);
                break;
        }
    }
}
