package ptit.nttrung.thibanglayxe.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ptit.nttrung.thibanglayxe.R;
import ptit.nttrung.thibanglayxe.model.License;
import ptit.nttrung.thibanglayxe.util.OnMyItemClickListener;

/**
 * Created by TrungNguyen on 11/20/2017.
 */

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

    private List<License> list;
    private Context context;
    private OnMyItemClickListener clickListener;

    public SettingAdapter(Context context, List<License> list) {
        this.list = list;
        this.context = context;
    }

    public void setClickListener(OnMyItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_class, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        License license = list.get(position);
        holder.name.setText("Bằng " + license.getLicense());
        holder.description.setText(license.getLicenseDes());
        if (!license.isSelected) {
            holder.imageView.setVisibility(View.INVISIBLE);
        } else {
            holder.imageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card__view)
        CardView cardView;
        @BindView(R.id.txt_name_license)
        TextView name;
        @BindView(R.id.txt_desc_license)
        TextView description;
        @BindView(R.id.iv_check)
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
