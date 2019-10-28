package mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import mainactivity.musicplayer.example.com.englishzubrila.corses.alphabet.FirstLevel;
import mainactivity.musicplayer.example.com.englishzubrila.corses.alphabet.test.TestAlphabet;
import mainactivity.musicplayer.example.com.englishzubrila.corses.articles.Articles;
import mainactivity.musicplayer.example.com.englishzubrila.corses.articles.test.TestArticles;
import mainactivity.musicplayer.example.com.englishzubrila.corses.can.Can;
import mainactivity.musicplayer.example.com.englishzubrila.corses.dodoes.DoDoes;
import mainactivity.musicplayer.example.com.englishzubrila.corses.haveto.HaveTo;
import mainactivity.musicplayer.example.com.englishzubrila.corses.must.Must;
import mainactivity.musicplayer.example.com.englishzubrila.corses.presentcontinuous.PresentContinuous;
import mainactivity.musicplayer.example.com.englishzubrila.corses.prularfrom.PluralForm;
import mainactivity.musicplayer.example.com.englishzubrila.corses.prularfrom.test.TestPluralForm;
import mainactivity.musicplayer.example.com.englishzubrila.corses.quastions.Questions;
import mainactivity.musicplayer.example.com.englishzubrila.corses.quastions.test.TestQuestions;
import mainactivity.musicplayer.example.com.englishzubrila.corses.simple.PresentSimple;
import mainactivity.musicplayer.example.com.englishzubrila.corses.simple.test.TestPresentSimple;
import mainactivity.musicplayer.example.com.englishzubrila.corses.teherels.ThereIS;
import mainactivity.musicplayer.example.com.englishzubrila.corses.teherels.test.TestTherelS;
import mainactivity.musicplayer.example.com.englishzubrila.corses.tobe.ToBe;
import mainactivity.musicplayer.example.com.englishzubrila.corses.tobe.test.TestToBe;
import mainactivity.musicplayer.example.com.englishzubrila.corses.transcription.Transcription;
import mainactivity.musicplayer.example.com.englishzubrila.corses.transcription.test.TestTranscription;
import mainactivity.musicplayer.example.com.englishzubrila.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagerbooks.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.enumlist.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model.Company;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.expandable.ProductAdapter;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class HomeFragment extends Fragment implements Listener {

    private RecyclerView recyclerView;
    private AlertDialog.Builder ad;
    private Context context;
    private View v;
    private Product product;
    private String title = "Пройди обучение или проверь себя тестированием";
    private String message = "И так, Ваш выбор?";
    private String button1String = "Тесты";
    private String button2String = "Курс";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getRecyclerView(view);
        getCompanies();
        context = HomeFragment.this.getContext();

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
        elementary.add(new Product("Present Simple", Beginner.Letters7));
        elementary.add(new Product("Do Does", Beginner.Letters8));
        elementary.add(new Product("Can", Beginner.Letters9));
        elementary.add(new Product("Present Continuous", Beginner.Letters10));
        elementary.add(new Product("Must", Beginner.Letters11));
        elementary.add(new Product("Have to", Beginner.Letters12));
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
        onClick(product);
       //
    }
    public void onClick(final Product product) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(title)
                    .setMessage(message)
                    .setCancelable(false)
                    .setNegativeButton(button2String, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    openActivity(product);
                                    dialog.cancel();
                                }
                            });
            builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                      openTest(product);
            }
        });
            AlertDialog alert = builder.create();
            alert.show();
        }

    private void openTest(Product product){
        Class b ;
        switch (product.getBeginner()){
            case Letters0:
                b = TestAlphabet.class;
                break;
            case Letters1:
                b = TestTranscription.class;
                break;
            case Letters2:
                b = TestToBe.class;
                break;
            case Letters3:
                b = TestQuestions.class;
                break;
            case Letters4:
                b = TestArticles.class;
                break;
            case Letters5:
                b = TestTherelS.class;
                break;
            case Letters6:
                b = TestPluralForm.class;
                break;
            case Letters7:
                b = TestPresentSimple.class;
                break;
            case Letters8:
                b = DoDoes.class;
                break;
            case Letters9:
                b = Can.class;
                break;
            case Letters11:
                b = Must.class;
                break;
            case Letters12:
                b = HaveTo.class;
                break;
            default:
                b = null;
                break;
        }
            Intent intent = new Intent(this.getActivity(), b);
            startActivity(intent);
    }

    private void openActivity(Product product) {
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
            case Letters7:
                biginer = PresentSimple.class;
                break;
            case Letters8:
                biginer = DoDoes.class;
                break;
            case Letters9:
                biginer = Can.class;
                break;
            case Letters10:
                biginer = PresentContinuous.class;
                break;
            case Letters11:
                biginer = Must.class;
                break;
            case Letters12:
                biginer = HaveTo.class;
                break;
            default:
                biginer = null;
                break;
        }
            Intent intent1 = new Intent(this.getActivity(), biginer);
            startActivity(intent1);
    }

    @Override
    public void onClikGaleri(Model model) {

    }
}