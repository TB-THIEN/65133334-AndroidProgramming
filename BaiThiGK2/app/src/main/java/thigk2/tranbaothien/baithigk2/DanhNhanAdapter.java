package thigk2.tranbaothien.baithigk2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DanhNhanAdapter extends RecyclerView.Adapter<DanhNhanAdapter.ItemLandHolder> {
    Context context;
    ArrayList<DanhNhan> listData;

    public DanhNhanAdapter(Context context, ArrayList<DanhNhan> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_danhnhan, parent, false);
        ItemLandHolder viewholderCreate = new ItemLandHolder(vItem);
        return viewholderCreate;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        DanhNhan danhNhanHienThi = listData.get(position);
        String caption = danhNhanHienThi.getDanhNhanCation();
        String tenFileAnh = danhNhanHienThi.getDanhNhanImageFileName();
        holder.tvCaption.setText(caption);

        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh,"mipmap", packageName);
        holder.ivDanhNhan.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivDanhNhan;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            ivDanhNhan = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDuocClick = getAbsoluteAdapterPosition();
            DanhNhan phanTuDuocClick = listData.get(viTriDuocClick);

            String ten = phanTuDuocClick.getDanhNhanCation();
            String tenFile = phanTuDuocClick.getDanhNhanImageFileName();

            String chuoiThongBao = "Bạn vừa click vào: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_LONG).show();

        }
    }
}
