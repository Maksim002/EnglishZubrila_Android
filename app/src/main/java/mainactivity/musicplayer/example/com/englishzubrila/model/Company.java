package mainactivity.musicplayer.example.com.englishzubrila.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Company extends ExpandableGroup<Product> {
    private int image;
    private String headline;

    public int getImage() {
        return image;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setImage(int image,String headline) {
        this.image = image;
        this.headline = headline;
    }

    public Company(String title, List<Product> items, int image, String headline) {
        super(title, items);
        this.image = image;
        this.headline = headline;
    }
}
