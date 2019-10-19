package mainactivity.musicplayer.example.com.englishzubrila.home;


import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagerbooks.model.Model;


public interface Listener {

    void onClikGaleri(int adapterPosition, Product product);

    void onClikGaleri(Model model);
}
