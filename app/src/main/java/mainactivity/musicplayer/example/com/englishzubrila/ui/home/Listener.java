package mainactivity.musicplayer.example.com.englishzubrila.ui.home;


import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.pagerbooks.model.Model;


public interface Listener {

    void onClikGaleri(int adapterPosition, Product product);

    void onClikGaleri(Model model);
}
