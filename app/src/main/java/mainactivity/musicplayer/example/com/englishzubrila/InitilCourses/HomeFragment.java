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

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.FirstLevel;
import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks.PhilipChesterfield;
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

        return view;
    }

    List<Content> getContact() {
        List<Content> contact = new ArrayList<>();
        contact.add(new Content( "Initial course",R.drawable.hcalla1));
        contact.add(new Content( "B разработке",R.drawable.hcalla2));
        contact.add(new Content( "B разработке",R.drawable.hcalla3));
        contact.add(new Content( "B разработке",R.drawable.hcalla4));
        contact.add(new Content( "B разработке",R.drawable.hcalla5));
        contact.add(new Content( "B разработке",R.drawable.hcalla6));
        return contact;
    }

    @Override
    public void onClikGaleri(int adapterPosition) {
        Intent intent = new Intent(this.getActivity(), FirstLevel.class);
        intent.putExtra(FirstLevel.Level,adapterPosition);
        startActivity(intent);
    }
}