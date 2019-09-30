package mainactivity.musicplayer.example.com.englishzubrila.glavList;


import mainactivity.musicplayer.example.com.englishzubrila.initiFragment.expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.initiFragment.contanerListViewPager.Model;


public interface Listener {

    void onClikGaleri(int adapterPosition, Product product);

    void onClikGaleri(Model model);
}
