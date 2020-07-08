package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.activity.ProductListActivity;
import softlogic_dealer_app.com.softlogic_dealer_app.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryListViewHolder> {

    private Context mContext;
    private List<Category> categoryList;

    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CategoryListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListViewHolder holder, int position) {
        final int categoryListIndex = position;
        Category category = categoryList.get(position);
        holder.title.setText(category.getCategoryName());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = categoryList.get(categoryListIndex);
                Intent intent = new Intent(mContext, ProductListActivity.class);
                intent.putExtra("category_name", category.getCategoryName());
                mContext.startActivity(intent);
            }
        });

        // loading category cover using Glide library
        Glide.with(mContext).load(category.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryListViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public CategoryListViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.category_title);
            thumbnail = view.findViewById(R.id.category_thumbnail);
        }
    }
}
