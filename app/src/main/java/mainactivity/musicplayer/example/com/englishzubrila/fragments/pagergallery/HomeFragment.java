package mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import mainactivity.musicplayer.example.com.englishzubrila.corses.alphabet.FirstLevel;
import mainactivity.musicplayer.example.com.englishzubrila.corses.articles.Articles;
import mainactivity.musicplayer.example.com.englishzubrila.corses.prularFrom.PluralForm;
import mainactivity.musicplayer.example.com.englishzubrila.corses.quastions.Questions;
import mainactivity.musicplayer.example.com.englishzubrila.corses.teherels.ThereIS;
import mainactivity.musicplayer.example.com.englishzubrila.corses.toBe.ToBe;
import mainactivity.musicplayer.example.com.englishzubrila.corses.transcription.Transcription;
import mainactivity.musicplayer.example.com.englishzubrila.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagerbooks.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.enumlist.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model.Company;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.expandable.ProductAdapter;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class HomeFragment extends Fragment implements Listener {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


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

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.down_animations);
        recyclerView.startAnimation(animation);
    }

    ArrayList<Product> getBeginner() {
        ArrayList<Product> beginer = new ArrayList<>();
        beginer.add(new Product("Alphabet", Beginner.Letters0));
        beginer.add(new Product("Transcription", Beginner.Letters1));
        beginer.add(new Product("To Be", Beginner.Letters2));
        beginer.add(new Product("Questions", Beginner.Letters3));
        beginer.add(new Product("Articles", Beginner.Letters4));
        beginer.add(new Product("There Is", Beginner.Letters5));
        beginer.add(new Product("Plural Form", Beginner.Letters6));
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
            case Letters4:
                biginer = Articles.class;
                break;
            case Letters5:
                biginer = ThereIS.class;
                break;
            case Letters6:
                biginer = PluralForm.class;
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
    public void onClikGaleri(Model model) {

    }
}