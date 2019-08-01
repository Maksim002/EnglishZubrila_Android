package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Enum.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks.Knigu.Hobbit;
import mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks.Knigu.SherlockHolmes;
import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class NewsFragment extends Fragment implements Listener {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);

        recyclerView = view.findViewById(R.id.recyclerViewFragmentNew);
        recyclerView.setAdapter(new Adaptor(getList(),this));

        return view;
    }
    List<Content> getList(){
        List<Content> context = new ArrayList<>();
        context.add(new Content("Hobbit"));
        context.add(new Content("Sherlock Holmes"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        //context.add(new Content("Philip Chesterfield - Letters to his Son"));
        return context;
    }


    @Override
    public void onClikGaleri(int adapterPosition, Product product) {

    }

    @Override
    public void onClikGaleri(int adapterPosition) {
        Intent intent;
        switch (adapterPosition){
            case 0:
                intent = new Intent(this.getActivity(), Hobbit.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this.getActivity(), SherlockHolmes.class);
                startActivity(intent);
                break;
        }

                //Intent intent1 = new Intent(this.getActivity(), SherlockHolmes.class);
                //intent1.putExtra("Sherlock Holmes",SherlockHolmes.sherlockHolmes);
                //startActivity(intent1);
    }
}

