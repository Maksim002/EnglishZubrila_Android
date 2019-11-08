package mainactivity.musicplayer.example.com.englishzubrila.ui.home;


import mainactivity.musicplayer.example.com.englishzubrila.model.Product;
import mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.books.model.Model;


public interface Listener {

    void onClickGallery(int adapterPosition, Product product);

    void onClickGallery(Model model);
}
