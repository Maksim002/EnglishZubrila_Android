package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Alphabet.FirstLevel;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Quastions.Questions;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.ToBe.ToBe;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.Transcription.Transcription;
import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Enum.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Company;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.ProductAdapter;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class HomeFragment<context> extends Fragment implements Listener {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Gallery");

        getRecyclerView(view);
        getCompanies();

        return view;
    }

    private void getCompanies(){
        ArrayList<Company> companies = new ArrayList<>();
        Company beginner = new Company("Beginner", getBeginner(), R.drawable.begin);
        companies.add(beginner);
        Company elementary = new Company("Elementary", getElementary(), R.drawable.elemen);
        companies.add(elementary);
        Company prointermediate = new Company("Pro Intermediate", getIntermediate(), R.drawable.pre_inter);
        companies.add(prointermediate);
        Company intermediate = new Company("Intermediate", getB1Intermediate(), R.drawable.inter);
        companies.add(intermediate);
        Company upperintermediate = new Company("Upper Intermediate", getUpperIntermediate(), R.drawable.upper_inter);
        companies.add(upperintermediate);
        Company advanced = new Company("Advanced", getC1Advanced(), R.drawable.advan);
        companies.add(advanced);


        ProductAdapter adapter = new ProductAdapter(companies, this);
        recyclerView.setAdapter(adapter);
    }

    private void getRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.recyclerView.getContext()));

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.down_to_up);
        recyclerView.startAnimation(animation);
    }

    ArrayList<Product> getBeginner() {
        ArrayList<Product> beginer = new ArrayList<>();
        beginer.add(new Product("Alphabet", Beginner.Letters0));
        beginer.add(new Product("Transcription", Beginner.Letters1));
        beginer.add(new Product("To Be", Beginner.Letters2));
        beginer.add(new Product("Questions", Beginner.Letters3));
        return beginer;
    }

    ArrayList<Product> getElementary() {
        ArrayList<Product> elementary = new ArrayList<>();
        elementary.add(new Product("Is empty", Beginner.Letters0));
        elementary.add(new Product("Is empty", Beginner.Letters0));
        elementary.add(new Product("Is empty", Beginner.Letters0));
        return elementary;
    }

    ArrayList<Product> getIntermediate() {
        ArrayList<Product> intermediate = new ArrayList<>();
        intermediate.add(new Product("Is empty", Beginner.Letters0));
        return intermediate;
    }

    ArrayList<Product> getB1Intermediate() {
        ArrayList<Product> b1intermediate = new ArrayList<>();
        b1intermediate.add(new Product("Is empty", Beginner.Letters0));
        return b1intermediate;
    }

    ArrayList<Product> getUpperIntermediate() {
        ArrayList<Product> upperintermediate = new ArrayList<>();
        upperintermediate.add(new Product("Is empty", Beginner.Letters0));
        return upperintermediate;
    }

    ArrayList<Product> getC1Advanced() {
        ArrayList<Product> c1advanced = new ArrayList<>();
        c1advanced.add(new Product("Is empty", Beginner.Letters0));
        return c1advanced;
    }

    @Override
    public void onClikGaleri(int adapterPosition, Product product) {
        Class biginer;
        switch (product.getBeginner()) {
            case Letters0:
                biginer = FirstLevel.class;
                break;
            case Letters1:
                biginer = Transcription.class;
                break;
            case Letters2:
                biginer = ToBe.class;
                break;
            case Letters3:
                biginer = Questions.class;
                break;
            default:
                biginer = null;
                break;
        }
        if (biginer != null) {
            Intent intent1 = new Intent(this.getActivity(), biginer);
            startActivity(intent1);
        }
    }

    @Override
    public void onClikGaleri(int adapterPosition) {

    }
}