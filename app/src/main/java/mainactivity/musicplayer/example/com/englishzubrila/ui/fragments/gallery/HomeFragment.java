package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery;


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

import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.alphabet.Alphabet;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.alphabet.test.TestAlphabet;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.articles.Articles;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.articles.test.TestArticles;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.can.Can;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.can.test.TestCan;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.comparative.ComparativeSuperlativeDegrees;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.direct.Directandindirectspeech;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.dodoes.DoDoes;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.dodoes.test.TestDoDoes;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.emty.IsEmty;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.haveto.HaveTo;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.must.Must;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.continuous.PresentContinuous;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.continuous.test.TestPresentContinuous;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.prular.PluralForm;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.prular.test.TestPluralForm;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.quastions.Questions;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.quastions.test.TestQuestions;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.PresentSimple;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.test.TestPresentSimple;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.teherels.ThereIS;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.teherels.test.TestTherelS;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.future.TheFutureSimple;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.tobe.ToBe;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.tobe.test.TestToBe;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.transcription.Transcription;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.transcription.test.TestTranscription;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.enumlist.Beginner;
import mainactivity.musicplayer.example.com.englishzubrila.model.Company;
import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.expandable.ProductAdapter;
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
        Company beginner = new Company("Beginner", getBeginner(), R.drawable.new_begin_new,"Учимся правильному чтению");
        companies.add(beginner);
        Company elementary = new Company("Elementary", getElementary(), R.drawable.new_elementary,"Получаем базовые знания");
        companies.add(elementary);
        Company prointermediate = new Company("Pro Intermediate", getIntermediate(), R.drawable.new_pre_intermediate,"Составляем сложные предложения");
        companies.add(prointermediate);
        Company intermediate = new Company("Intermediate", getB1Intermediate(), R.drawable.new_intermediate,"Изучение тонкостей языка");
        companies.add(intermediate);
        Company upperintermediate = new Company("Upper Intermediate", getUpperIntermediate(), R.drawable.new_upper_intermediate,"Чтение и понимание");
        companies.add(upperintermediate);
        Company advanced = new Company("Advanced", getC1Advanced(), R.drawable.new_advanced,"Расширяем кругозор");
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
        intermediate.add(new Product("Direct and indirect speech", Beginner.Letters13));
        intermediate.add(new Product("The Future Simple", Beginner.Letters14));
        intermediate.add(new Product("Comparative and Superlative Degrees", Beginner.Letters15));
        return intermediate;
    }
    ArrayList<Product> getB1Intermediate() {
        ArrayList<Product> b1intermediate = new ArrayList<>();
        b1intermediate.add(new Product("Is empty", Beginner.Letters16));
        return b1intermediate;
    }
    ArrayList<Product> getUpperIntermediate() {
        ArrayList<Product> upperintermediate = new ArrayList<>();
        upperintermediate.add(new Product("Is empty", Beginner.Letters16));
        return upperintermediate;
    }

    ArrayList<Product> getC1Advanced() {
        ArrayList<Product> c1advanced = new ArrayList<>();
        c1advanced.add(new Product("Is empty", Beginner.Letters16));
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
                      dialog.cancel();
            }
        });
            AlertDialog alert = builder.create();
            alert.show();
        }

    private void openTest(Product product){
        Class test ;
        switch (product.getBeginner()){
            case Letters0:
                test = TestAlphabet.class;
                break;
            case Letters1:
                test = TestTranscription.class;
                break;
            case Letters2:
                test = TestToBe.class;
                break;
            case Letters3:
                test = TestQuestions.class;
                break;
            case Letters4:
                test = TestArticles.class;
                break;
            case Letters5:
                test = TestTherelS.class;
                break;
            case Letters6:
                test = TestPluralForm.class;
                break;
            case Letters7:
                test = TestPresentSimple.class;
                break;
            case Letters8:
                test = TestDoDoes.class;
                break;
            case Letters9:
                test = TestCan.class;
                break;
            case Letters11:
                test = TestPresentContinuous.class;
                break;
            case Letters12:
                test = HaveTo.class;
                break;
            case Letters13:
                test = Directandindirectspeech.class;
                break;
            case Letters14:
                test = TheFutureSimple.class;
                break;
            case Letters15:
                test = ComparativeSuperlativeDegrees.class;
                break;
            case Letters16:
                test = IsEmty.class;
                break;
            default:
                test = null;
                break;
        }
            Intent intent = new Intent(this.getActivity(), test);
            startActivity(intent);
    }

    private void openActivity(Product product) {
        Class beginner;
        switch (product.getBeginner()) {
            case Letters0:
                beginner = Alphabet.class;
                break;
            case Letters1:
                beginner = Transcription.class;
                break;
            case Letters2:
                beginner = ToBe.class;
                break;
            case Letters3:
                beginner = Questions.class;
                break;
            case Letters4:
                beginner = Articles.class;
                break;
            case Letters5:
                beginner = ThereIS.class;
                break;
            case Letters6:
                beginner = PluralForm.class;
                break;
            case Letters7:
                beginner = PresentSimple.class;
                break;
            case Letters8:
                beginner = DoDoes.class;
                break;
            case Letters9:
                beginner = Can.class;
                break;
            case Letters10:
                beginner = PresentContinuous.class;
                break;
            case Letters11:
                beginner = Must.class;
                break;
            case Letters12:
                beginner = HaveTo.class;
                break;
            case Letters13:
                beginner = Directandindirectspeech.class;
                break;
            case Letters14:
                beginner = TheFutureSimple.class;
                break;
            case Letters15:
                beginner = ComparativeSuperlativeDegrees.class;
                break;
            case Letters16:
                beginner = IsEmty.class;
                break;
            default:
                beginner = null;
                break;
        }
            Intent intentCourses = new Intent(this.getActivity(), beginner);
            startActivity(intentCourses);
    }

    @Override
    public void onClikGaleri(Model model) {

    }
}