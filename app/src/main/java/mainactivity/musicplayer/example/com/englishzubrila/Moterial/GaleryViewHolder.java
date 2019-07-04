package mainactivity.musicplayer.example.com.englishzubrila.Moterial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mainactivity.musicplayer.example.com.englishzubrila.R;

class GaleryViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public GaleryViewHolder(@NonNull View itemView, final Listener listener) {
        super(itemView);
       textView = itemView.findViewById(R.id.textView2);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onClikGaleri(getAdapterPosition());
           }
       });
    }

    public void bind(Contact contact) {
        textView.setText(contact.getName() + " " + contact.getPhoneNmabers());
    }
}
