package mainactivity.musicplayer.example.com.englishzubrila.ui.fragments.gallery.enumlist;

public enum  Beginner {
    Letters0(0),
    Letters1(1),
    Letters2(2),
    Letters3(3),
    Letters4(4),
    Letters5(5),
    Letters6(6),
    Letters7(7),
    Letters8(8),
    Letters9(9),
    Letters10(10),
    Letters11(11),
    Letters12(12),
    Letters13(13),
    Letters14(14),
    Letters15(15),
    Letters16(16),
    Letters17(17);

    private final int id;

    Beginner(int code){
        id = code;
    }

    public int getId() {
        return id;
    }

    public static Beginner fromId(int code)
    {
        Beginner[] list = Beginner.values();

        if (code >= 0 && code < list.length)
            return list[code];
        else
            return Beginner.Letters0;
    }
}
