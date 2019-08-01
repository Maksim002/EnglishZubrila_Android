package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

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

import java.util.ArrayList;

import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Beginer.FirstLevel;
import mainactivity.musicplayer.example.com.englishzubrila.FirstLevel.Elementary.A1Elementary;
import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Enum.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Company;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable.ProductAdapter;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class HomeFragment extends Fragment implements Listener {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.recyclerView.getContext()));

        ArrayList<Company> companies = new ArrayList<>();

        Company beginner = new Company("A0 Beginner",getBeginner());
        companies.add(beginner);
        Company elementary = new Company("A1 Elementary", getElementary());
        companies.add(elementary);
        Company prointermediate = new Company("A2 Pro Intermediate",getIntermediate());
        companies.add(prointermediate);
        Company intermediate = new Company("B1 Intermediate", getB1Intermediate());
        companies.add(intermediate);
        Company upperintermediate = new Company("B2 Upper Intermediate", getUpperIntermediate());
        companies.add(upperintermediate);
        Company advanced = new Company("C1 Advanced", getC1Advanced());
        companies.add(advanced);


        ProductAdapter adapter = new ProductAdapter(companies,this);
        recyclerView.setAdapter(adapter);

        return view;
    }
    ArrayList<Product> getBeginner(){
        ArrayList<Product> beginer = new ArrayList<>();
        beginer.add(new Product("Letters", Beginner.Letters0));
        beginer.add(new Product("Transcription", Beginner.Letters1));
        beginer.add(new Product("Is empty", Beginner.Letters0));
        return beginer;
    }
    ArrayList<Product> getElementary(){
        ArrayList<Product> elementary = new ArrayList<>();
        elementary.add(new Product("Is empty", Beginner.Letters0));
        elementary.add(new Product("Is empty", Beginner.Letters0));
        elementary.add(new Product("Is empty", Beginner.Letters0));
        return elementary;
    }
    ArrayList<Product> getIntermediate(){
        ArrayList<Product> intermediate = new ArrayList<>();
        intermediate.add(new Product("Is empty", Beginner.Letters0));
        return intermediate;
    }
    ArrayList<Product> getB1Intermediate(){
        ArrayList<Product> b1intermediate = new ArrayList<>();
        b1intermediate.add(new Product("Is empty", Beginner.Letters0));
        return b1intermediate;
    }
    ArrayList<Product> getUpperIntermediate(){
        ArrayList<Product> upperintermediate = new ArrayList<>();
        upperintermediate.add(new Product("Is empty", Beginner.Letters0));
        return upperintermediate;
    }
    ArrayList<Product> getC1Advanced(){
        ArrayList<Product> c1advanced = new ArrayList<>();
        c1advanced.add(new Product("Is empty", Beginner.Letters0));
        return c1advanced;
    }



     @Override
    public void onClikGaleri(int adapterPosition, Product product) {
            Class biginer;
            switch (product.getBeginner()){
                case Letters0:
                    biginer = FirstLevel.class;
                    break;
                case Letters1:
                    biginer = A1Elementary.class;
                    break;
                default:
                    biginer = null;
                    break;
            }
            if (biginer != null){
                Intent intent1 = new Intent(this.getActivity(), biginer);
                startActivity(intent1);
       }
    }

    @Override
    public void onClikGaleri(int adapterPosition) {

    }
}