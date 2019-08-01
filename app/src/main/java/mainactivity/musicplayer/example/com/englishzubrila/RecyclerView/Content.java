package mainactivity.musicplayer.example.com.englishzubrila.RecyclerView;

import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Enum.Beginner;

public class Content {
    private String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName(int adapterPosition) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}