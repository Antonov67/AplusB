package com.example.aplusb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText fieldA, fieldB;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        fieldA = findViewById(R.id.field_a);
        fieldB = findViewById(R.id.field_b);
        resultTextView = findViewById(R.id.result_text_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strA = fieldA.getText().toString();
                String strB = fieldB.getText().toString();
                try {
                    double a = Double.parseDouble(strA);
                    double b = Double.parseDouble(strB);
                    resultTextView.setText(a + " + " + b + " = " + (a + b));
                }catch (Exception e){
                    resultTextView.setText("Введите числа!");
                }


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}