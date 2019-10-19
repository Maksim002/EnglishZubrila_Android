package mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Company extends ExpandableGroup<Product> {
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Company(String title, List<Product> items, int image) {
        super(title, items);
        this.image = image;
    }
}
