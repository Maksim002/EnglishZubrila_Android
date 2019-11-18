package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.galeryadaptor.GalleryAdaptar;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.galeryadaptor.GalleryPegerAdaptar;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.Model;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.model.Gallery;
import mainactivity.musicplayer.example.com.englishzubrila.ui.home.Listener;

public class CheatSheets extends AppCompatActivity implements Listener {
    private Toolbar toolbar;
    private ActionBar actionBar;

    private RecyclerView recyclerView;
    private GalleryAdaptar adaptar;

    private ViewPager pager;
    private GalleryPegerAdaptar pegerAdaptar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main_galery);

        toolbar = findViewById(R.id.toolGallery);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Cheat sheets");

        List<Gallery> temp = getGalleryImages();
        setupRecyclerView(temp);
        setupViewPager(temp);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupViewPager(List<Gallery> images){
        pager = findViewById(R.id.viewPager);
        pager.setAdapter(pegerAdaptar = new GalleryPegerAdaptar());
        pegerAdaptar.updeteList(images);
    }

    private void setupRecyclerView(List<Gallery> images){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adaptar = new GalleryAdaptar(this));
        adaptar.setGalleryList(images);
    }

    @Override
    public void onClickGallery(int adapterPosition, Product product) {
    }
    @Override
    public void onClickGallery(Model model) {
    }
    @Override
    public void onClickGallery(int position) {
        pager.setCurrentItem(position, false);
        pager.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    private List<Gallery> getGalleryImages(){
        List<Gallery> temp = new ArrayList<>();
        temp.add(new Gallery("https://www.helloangielski.pl/rozmowki/wp-content/uploads/2015/11/alfabet-angielski-z-wymowa.png","Alphabet", getResources().getColor(R.color.imageO)));
        temp.add(new Gallery("http://kiratty.com/uploads/posts/2015-01/1421390295_abcfull.jpg","Transcriptions", getResources().getColor(R.color.imageU)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-32.jpg","Transcriptions", getResources().getColor(R.color.imageP)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-34.jpg","To Be", getResources().getColor(R.color.imageO)));
        temp.add(new Gallery("https://i.pinimg.com/originals/63/0c/ee/630cee26731e3217cfb8e45fcf6fb58d.gif","Colors", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://i.pinimg.com/originals/c3/9a/8b/c39a8b17dcb5a1694f7c98bfa5812919.jpg","Food", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://www.schofieldandsims.co.uk/prodlarge/77.jpg","Fruits", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://7esl.com/wp-content/uploads/2017/12/Vegetables.jpg","Vegetables", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://ae01.alicdn.com/kf/HTB1QrAvLXXXXXcBXVXXq6xXFXXXa/-.jpg","Meals", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://i.pinimg.com/originals/ff/f7/7b/fff77b52e939fb14eae5d1fb3192d51f.png","Animals", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://i.pinimg.com/originals/3c/87/bd/3c87bd9f9cba788d7e5607be0d2b74a8.jpg","Animals", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("http://preschool.wordzila.com/wp-content/uploads/sites/2/LKG-Science-Book_Page_26.png","Animals", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://7esl.com/wp-content/uploads/2018/04/Verbs.jpg","Actions", getResources().getColor(R.color.imageY)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-29.jpg","Articles", getResources().getColor(R.color.imageQ)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-30.jpg","Key words P.S.", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-31.jpg","Present Simple N", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-36.jpg","Present Simple P", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-35.jpg","Present Simple Q", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-27.jpg","Present Continuous", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://englishfull.ru/wp-content/uploads/2018/02/simple-continious1.jpg.webp","P.S. vs P.C.", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://shkola7gnomov.ru/upload/resize_cache/iblock/5e0/1500_800_1/5e09d28f2aeabd7fef30d220c2cecf2c.jpg","Irregular verb", getResources().getColor(R.color.imageT)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-28.jpg","Key words P.C.", getResources().getColor(R.color.imageW)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-33.jpg","Room", getResources().getColor(R.color.imageI)));
        temp.add(new Gallery("https://content.foto.my.mail.ru/mail/inoplanee/26/h-37.jpg","Have to and Must", getResources().getColor(R.color.imageE)));
        return temp;
    }

    @Override
    public void onDismiss() {
        if (pager.getVisibility() == View.VISIBLE) {
            pager.setVisibility(View.GONE);
        }else {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        if (pager.getVisibility() == View.VISIBLE) {
            pager.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}
