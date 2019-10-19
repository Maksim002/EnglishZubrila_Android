package mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.model;

import android.os.Parcel;
import android.os.Parcelable;

import mainactivity.musicplayer.example.com.englishzubrila.fragments.pagergallery.enumlist.Beginner;

public class Product implements Parcelable {
    public final String name;
    private Beginner beginner;

    public Product(String name,Beginner beginner) {
        this.name = name;
        this.beginner = beginner;
    }

    public Beginner getBeginner() {
        return beginner;
    }

    protected Product(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
