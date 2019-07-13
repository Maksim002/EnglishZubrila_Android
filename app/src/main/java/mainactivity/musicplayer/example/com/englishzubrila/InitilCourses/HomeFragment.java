package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

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
import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class HomeFragment extends Fragment implements Listener {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new Adaptor( getContact(), this));

        Adaptor adaptor = new Adaptor( getContact(), this);

        return view;
    }

    List<Content> getContact() {
        List<Content> contact = new ArrayList<>();
        contact.add(new Content( "Initial course"));
        contact.add(new Content( "B разработке"));
        return contact;
    }

    @Override
    public void onClikGaleri(int adapterPosition) {

    }
}