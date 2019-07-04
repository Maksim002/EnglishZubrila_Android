package mainactivity.musicplayer.example.com.englishzubrila.InitialСourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class Initialcourse extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_course);

        recyclerView = findViewById(R.id.recyclerViewInitial);
        recyclerView.setAdapter(new TestAdaptor(this, getList()));

    }
    List<Context> getList(){
        List<Context> context = new ArrayList<>();
        context.add(new Context("",getString(R.string.text_english) ));
        context.add(new Context("","Перевод"));
        context.add(new Context("",getString(R.string.text_rus)));
        return context;
    }
}
