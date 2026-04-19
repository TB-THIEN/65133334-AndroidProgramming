package com.tbt65133334.testgk;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Cau4Fragment extends Fragment {

    private TextView tvBotChoice, tvResult, tvScore;
    private Button btnKeo, btnBua, btnBao, btnReset;
    private int botScore = 0;
    private int playerScore = 0;

    public Cau4Fragment() {

    }

    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau4, container, false);

        tvBotChoice = view.findViewById(R.id.tv_BotChoice);
        tvResult = view.findViewById(R.id.tv_Result);
        tvScore = view.findViewById(R.id.tv_Score);
        btnKeo = view.findViewById(R.id.btn_Keo);
        btnBua = view.findViewById(R.id.btn_Bua);
        btnBao = view.findViewById(R.id.btn_Bao);
        btnReset = view.findViewById(R.id.btn_Reset);

        btnKeo.setOnClickListener(v -> playGame(0));
        btnBua.setOnClickListener(v -> playGame(1));
        btnBao.setOnClickListener(v -> playGame(2));

        btnReset.setOnClickListener(v -> {
            botScore = 0;
            playerScore = 0;
            tvScore.setText("Máy: 0  |  Bạn: 0");
            tvResult.setText("Mời bạn ra chiêu!");
            tvResult.setTextColor(Color.BLACK);
            tvBotChoice.setText("🤖");
        });

        return view;
    }

    private void playGame(int playerChoice) {
        int botChoice = new Random().nextInt(3);

        if (botChoice == 0) tvBotChoice.setText("✌️");
        else if (botChoice == 1) tvBotChoice.setText("✊");
        else tvBotChoice.setText("✋");

        if (playerChoice == botChoice) {
            tvResult.setText("HÒA NHAU!");
            tvResult.setTextColor(Color.GRAY);
        } else if ((playerChoice == 0 && botChoice == 2) ||
                (playerChoice == 1 && botChoice == 0) ||
                (playerChoice == 2 && botChoice == 1)) {
            tvResult.setText("BẠN THẮNG! 🎉");
            tvResult.setTextColor(Color.parseColor("#4CAF50"));
            playerScore++;
        } else {
            tvResult.setText("MÁY THẮNG! 😢");
            tvResult.setTextColor(Color.parseColor("#F44336"));
            botScore++;
        }

        tvScore.setText("Máy: " + botScore + "  |  Bạn: " + playerScore);
    }
}