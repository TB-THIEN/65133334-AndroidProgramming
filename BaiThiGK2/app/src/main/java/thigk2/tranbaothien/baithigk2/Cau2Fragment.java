package thigk2.tranbaothien.baithigk2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.BaiHatViewHolder> {

    Context context;
    ArrayList<BaiHat> listBaiHat;

    public BaiHatAdapter(Context context, ArrayList<BaiHat> listBaiHat) {
        this.context = context;
        this.listBaiHat = listBaiHat;
    }

    @NonNull
    @Override
    public BaiHatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_baihat, parent, false);
        return new BaiHatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatViewHolder holder, int position) {
        BaiHat baiHat = listBaiHat.get(position);
        holder.tvTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.tvCaSi.setText(baiHat.getCaSi());
    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }

    class BaiHatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTenBaiHat, tvCaSi;

        public BaiHatViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenBaiHat = itemView.findViewById(R.id.tvTenBaiHat);
            tvCaSi = itemView.findViewById(R.id.tvCaSi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int vitri = getAbsoluteAdapterPosition();
            BaiHat baiHatDuocChon = listBaiHat.get(vitri);
            Toast.makeText(context, "Đang phát bài: " + baiHatDuocChon.getTenBaiHat(), Toast.LENGTH_SHORT).show();
        }
    }
}