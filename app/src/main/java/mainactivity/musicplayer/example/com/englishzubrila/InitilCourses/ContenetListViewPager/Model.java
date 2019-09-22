package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.ContenetListViewPager;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private int image;
    private String name;
    private int text;
    private String url;

    public Model(int image, String name, int text, String url) {
        this.image = image;
        this.name = name;
        this.text = text;
        this.url = url;
    }

    protected Model(Parcel in) {
        image = in.readInt();
        name = in.readString();
        text = in.readInt();
        url = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(name);
        parcel.writeInt(text);
        parcel.writeString(url);
    }
}
