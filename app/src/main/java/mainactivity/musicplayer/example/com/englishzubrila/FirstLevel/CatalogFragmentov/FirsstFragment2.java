package mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.CatalogFragmentov;

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

import mainactivity.musicplayer.example.com.englishzubrila.R;

public class FirsstFragment2 extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment3,container,false);

        recyclerView = view.findViewById(R.id.recyclerViewFragment);
        recyclerView.setAdapter(new FirstAdaptor(this, getTemp()));

        return view;
    }
    List<Temp> getTemp() {
        List<Temp> temps = new ArrayList<>();
        temps.add(new Temp(R.drawable.a));
        temps.add(new Temp(R.drawable.b));
        temps.add(new Temp(R.drawable.c));
        temps.add(new Temp(R.drawable.d));
        temps.add(new Temp(R.drawable.i));
        temps.add(new Temp(R.drawable.f));
        temps.add(new Temp(R.drawable.j));
        temps.add(new Temp(R.drawable.l));
        temps.add(new Temp(R.drawable.i));
        temps.add(new Temp(R.drawable.h));
        temps.add(new Temp(R.drawable.g));
        return temps;
    }
}
