package mainactivity.musicplayer.example.com.englishzubrila.ListOfbooks.Knigu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.RecyclerView.Content;

public class SherlockHolmes extends AppCompatActivity {

    public static final String sherlockHolmes = "Sherlock Holmes";
    private PDFView pdfView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dizane_book);

        pdfView = findViewById(R.id.pdfBook);
        pdfView.fromAsset("sherloch.PDF").load();

        Content content = getIntent().getParcelableExtra(SherlockHolmes.sherlockHolmes);
    }
}
