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
        context.add(new Context(" I love spring. It is a wonderful season.\n" +
                " Spring comes and nature awakens from its winter sleep. The days become longer and the nights become shorter.\n" +
                " The ground is covered with fresh green grass and the first spring flowers. How lovely the white snowdrops are! There are new leaves and blossoms on the trees.\n" +
                " The birds begin to sing and build their nests. The air is fresh and the sun shines brightly.\n" +
                " The days are warm and everything is full of life and joy. Everybody feels younger and stronger.\n" +
                " Many people like spring more than other seasons. It is very pleasant to watch how the nature awakens from the winter sleep.\n" +
                " In spring we can go to the country and have a walk in the woods or by the river, play ball-games, lie in the sun and even have a swim if the water is warm enough.\n" +
                " That is why I like spring more than any other season of the year.",""));
        context.add(new Context("Перевод:\n" +
                " Я люблю весну. Это прекрасное время года.\n" +
                " Весна приходит и природа просыпается от зимней спячки. Дни становятся длиннее, а ночи становятся короче.\n" +
                " Земля покрыта свежей зеленой травой и появляются первые весенние цветы. Какая прелесть белые подснежники! Появляются новые листья и цветы на деревьях.\n" +
                " Птицы начинают петь и строить свои гнезда. Воздух свеж, и ярко светит солнце.\n" +
                " Дни теплые и все полно жизни и радости. Каждый чувствует себя моложе и сильнее.\n" +
                " Многие люди любят весну больше, чем другие времена года. Очень приятно наблюдать, как природа просыпается от зимнего сна. \n" +
                " Весной мы можем поехать за город и прогулятся в лесу или по берегу реки, играть в игры с мячом, полежать на солнце и даже поплавать, если вода достаточно теплая.\n" +
                " от почему я люблю весну больше, чем любое другое время года.",""));
        return context;
    }
}
