package thigk2.tranbaothien.baithigk2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {

    EditText edtTienVND;
    Button btnChuyenDoi;
    TextView txtKetQua;

    final double TY_GIA = 25000.0;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        edtTienVND = view.findViewById(R.id.edtTienVND);
        btnChuyenDoi = view.findViewById(R.id.btnChuyenDoi);
        txtKetQua = view.findViewById(R.id.txtKetQua);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thucHienChuyenDoi();
            }
        });

        return view;
    }

    private void thucHienChuyenDoi() {
        String chuoiTienVND = edtTienVND.getText().toString().trim();

        if (chuoiTienVND.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập số tiền cần đổi!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double tienVND = Double.parseDouble(chuoiTienVND);

            double tienUSD = tienVND / TY_GIA;

            String ketQua = String.format("Kết quả: %.2f USD", tienUSD);

            txtKetQua.setText(ketQua);

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Dữ liệu nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}