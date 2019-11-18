package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.heatsheets.model;

public class Gallery {
    private String images;
    private String Name;
    private int color;

    public Gallery(String images, String name, int color) {
        this.images = images;
        Name = name;
        this.color = color;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
