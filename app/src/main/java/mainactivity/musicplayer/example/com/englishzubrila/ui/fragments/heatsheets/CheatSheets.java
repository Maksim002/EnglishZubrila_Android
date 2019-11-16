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

        toolbar = findViewById(R.id.toolGalery);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Cheat sheets");

        List<String> temp = getGalleryImages();
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
    private void setupViewPager(List<String> images){
        pager = findViewById(R.id.viewPager);
        pager.setAdapter(pegerAdaptar = new GalleryPegerAdaptar());
        pegerAdaptar.updeteList(images);
    }

    private void setupRecyclerView(List<String> images){
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

    private List<String> getGalleryImages(){
        List<String> temp = new ArrayList<>();
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-16.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-15.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-13.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-10.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-8.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-7.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-14.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-11.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-12.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-9.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-20.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-17.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-18.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-19.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-22.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-25.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-23.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-21.jpg");
        temp.add("https://content.foto.my.mail.ru/mail/inoplanee/6/h-24.jpg");
        temp.add("https://it-developer.in.ua/wp-content/uploads/2015/12/alphabet.jpg");
        temp.add("https://englishfull.ru/wp-content/uploads/2015/07/frukty.jpg");
        temp.add("https://img1.liveinternet.ru/images/attach/c/6/124/574/124574781_image.jpg");
        temp.add("https://pp.userapi.com/xWsTRjFI9Yoh-81_ONbX-k8rro6dCY0Wvkwzpw/UAOOhO2wiLM.jpg");
        temp.add("https://img11.postila.ru/data/b7/03/98/77/b70398778c885a6d65780c2afe459d0afbf9deec351c7f675061c841d3307aad.png");
        temp.add("https://img14.postila.ru/resize?w=460&src=%2Fdata%2Ff1%2F5a%2Fa4%2F21%2Ff15aa421dbf36e458facccff2c04b0a4a31c0bd730c37e00e2da364bb4ce4136.png");
        temp.add("https://img.yakaboo.ua/media/catalog/product/cache/1/image/398x565/234c7c011ba026e66d29567e1be1d1f7/1/0/1010742629.jpg");
        temp.add("https://ic.pics.livejournal.com/1way_to_english/53463037/2333011/2333011_original.png");
        temp.add("https://img13.postila.ru/resize?w=370&src=%2Fdata%2F23%2F12%2Fbf%2F36%2F2312bf36ed5d5d1a220d87cdcc0ac051f95eea151cd3baae430e7b8ec72263c5.jpg");
        temp.add("https://img.labirint.ru/rcimg/de4e45e30aad5b92899c80154effc010/1920x1080/comments_pic/1517/6_4ac12afa06cb9dab70836bde87f37f09_1429688812.jpg");
        temp.add("http://englishstory.ru/wp-content/uploads/2014/11/Obuchenie-chteniyu-Aa-kartinka-mal.jpg");
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
