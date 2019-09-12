package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.Expandable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.Glav.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class ProductAdapter extends ExpandableRecyclerViewAdapter<CompaniViewHolder, ProductViewHolder> {
    private Listener listener;


     public ProductAdapter(List<? extends ExpandableGroup> groups, Listener listener) {
        super(groups);
        this.listener = listener;
    }

    @Override
    public CompaniViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_initi_company, parent,false);
        return new CompaniViewHolder(view);
    }

    @Override
    public ProductViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_initi_product, parent,false);
        return new ProductViewHolder(view, listener);
    }

    @Override
    public void onBindChildViewHolder(ProductViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Product product = (Product) group.getItems().get(childIndex);
        holder.bind(product);
    }

    @Override
    public void onBindGroupViewHolder(CompaniViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Company company = (Company) group;
        holder.bind(company);
    }
}
