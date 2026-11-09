package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons;
    private Button btnReset;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        buttons[i][j].setText("");
                        buttons[i][j].setEnabled(true);
                    }
                }

            }
        });

        buttons = new Button[3][3];
        buttons[0][0] = findViewById(R.id.btn0);
        buttons[0][1] = findViewById(R.id.btn1);
        buttons[0][2] = findViewById(R.id.btn2);
        buttons[1][0] = findViewById(R.id.btn3);
        buttons[1][1] = findViewById(R.id.btn4);
        buttons[1][2] = findViewById(R.id.btn5);
        buttons[2][0] = findViewById(R.id.btn6);
        buttons[2][1] = findViewById(R.id.btn7);
        buttons[2][2] = findViewById(R.id.btn8);

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if(counter%2 == 0)
            btn.setText("X");
        else
            btn.setText("O");
        counter++;
        btn.setEnabled(false);

    }
}