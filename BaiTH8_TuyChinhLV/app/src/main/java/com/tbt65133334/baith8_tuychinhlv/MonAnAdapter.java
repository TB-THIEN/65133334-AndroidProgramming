package com.tbt65133334.baith8_tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {

    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewhienHanh = view;

        if(viewhienHanh == null)
            viewhienHanh = layoutInflater.inflate(R.layout.item_mon, null);
        MonAn monAnHienTai = dsMonAn.get(i);

        TextView textView_TenMon = (TextView) viewhienHanh.findViewById(R.id.tvTenMon);
        TextView textView_DonGia = (TextView) viewhienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewhienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_Anh = (ImageView) viewhienHanh.findViewById(R.id.AnhDaiDien);

        textView_TenMon.setText(monAnHienTai.getMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_Anh.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return viewhienHanh;

    }
}