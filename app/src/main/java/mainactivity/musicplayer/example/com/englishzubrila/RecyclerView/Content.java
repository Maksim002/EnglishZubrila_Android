package mainactivity.musicplayer.example.com.englishzubrila.RecyclerView;

public class Content {
    private String name;
    private int imeg;

    public int getImeg(int adapterPosition) {
        return imeg;
    }

    public void setImeg(int imeg) {
        this.imeg = imeg;
    }

    public Content(String name, int imeg) {
        this.name = name;
        this.imeg = imeg;
    }

    public String getName(int adapterPosition) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
