package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.content.Context;
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
import softlogic_dealer_app.com.softlogic_dealer_app.model.RankedSalesPerson;

public class RankedSalesAdapter extends RecyclerView.Adapter<RankedSalesAdapter.RankedListViewHolder> {

    private Context mContext;
    private List<RankedSalesPerson> rankedSalesPersonList;

    public RankedSalesAdapter(Context mContext, List<RankedSalesPerson> rankedSalesPersonList) {
        this.mContext = mContext;
        this.rankedSalesPersonList = rankedSalesPersonList;
    }


    @NonNull
    @Override
    public RankedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranked_list_item, parent, false);
        return new RankedSalesAdapter.RankedListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RankedListViewHolder holder, int position) {
        RankedSalesPerson rankedSalesPerson = rankedSalesPersonList.get(position);
        // loading category cover using Glide library
        holder.rankNumber.setText(String.valueOf(rankedSalesPerson.getRankNumber()));
        holder.salesPersonName.setText(rankedSalesPerson.getSalesPersonName());
        holder.salesPersonAffiliateCompany.setText(rankedSalesPerson.getAffiliateCompany());
        holder.soldProductAmount.setText(String.valueOf(rankedSalesPerson.getSoldProductQuantity()));
        Glide.with(mContext).load(rankedSalesPerson.getSalesPersonThumbnail()).into(holder.thumbnail);

        if (position == 0) {
            holder.firstPlaceThumbnail.setVisibility(View.VISIBLE);
        } else {
            holder.firstPlaceThumbnail.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return rankedSalesPersonList.size();
    }

    public class RankedListViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail, firstPlaceThumbnail;
        public TextView rankNumber;
        public TextView salesPersonName;
        public TextView salesPersonAffiliateCompany;
        public TextView soldProductAmount;

        public RankedListViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.sales_person_thumbnail);
            rankNumber = view.findViewById(R.id.rank_number);
            salesPersonName = view.findViewById(R.id.sales_person_name);
            salesPersonAffiliateCompany = view.findViewById(R.id.sales_person_affiliate_company);
            soldProductAmount = view.findViewById(R.id.sold_product_amount);
            firstPlaceThumbnail = view.findViewById(R.id.first_place_thumbnail);
        }
    }
}
