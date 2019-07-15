package mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks;

import android.os.Parcel;
import android.os.Parcelable;

public class Spisoc implements Parcelable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spisoc(String name) {
        this.name = name;
    }

    protected Spisoc(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Spisoc> CREATOR = new Creator<Spisoc>() {
        @Override
        public Spisoc createFromParcel(Parcel in) {
            return new Spisoc(in);
        }

        @Override
        public Spisoc[] newArray(int size) {
            return new Spisoc[size];
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
