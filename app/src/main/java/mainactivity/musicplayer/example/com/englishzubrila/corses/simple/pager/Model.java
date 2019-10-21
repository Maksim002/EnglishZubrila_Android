package mainactivity.musicplayer.example.com.englishzubrila.corses.simple.pager;

import android.os.Parcel;
import android.os.Parcelable;

public class Model {

    private int image;

    public Model(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
