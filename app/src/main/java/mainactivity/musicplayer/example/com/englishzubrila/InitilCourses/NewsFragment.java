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

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks.PhilipChesterfield;
import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class NewsFragment extends Fragment implements Listener {
    RecyclerView recyclerView;

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
        context.add(new Content("Philip Chesterfield - Letters to his Son"));
        context.add(new Content("George Grossmith - The Diary of a Nobody"));
        context.add(new Content("Ernest Hemingway - The Old Man and the Sea (+ Movie Clip)"));
        context.add(new Content("Lewis Carroll - Alice in Wonderland"));
        context.add(new Content("Daniel Defoe - Robinson Crusoe (+Movie Clip)"));
        context.add(new Content("Winston Churchill - Richard Carvel"));
        context.add(new Content("George Orwell - Animal Farm (+Cartoon)"));
        return context;
    }

    @Override
    public void onClikGaleri(int adapterPosition) {
        Intent intent = new Intent(this.getActivity(), PhilipChesterfield.class);
        intent.putExtra(PhilipChesterfield.move,adapterPosition);
        startActivity(intent);
    }
}
