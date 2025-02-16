package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private String currentInput = "";
    private double firstNumber = 0.0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        setNumericButtonClickListener();
        setOperatorButtonClickListener();
        findViewById(R.id.buttonClear).setOnClickListener(v -> {
            currentInput = "";
            firstNumber = 0.0;
            operator = "";
            resultText.setText("0");
        });
    }

    private void setNumericButtonClickListener() {
        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            currentInput += button.getText().toString();
            resultText.setText(currentInput);
        };

        findViewById(R.id.button0).setOnClickListener(listener);
        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
        findViewById(R.id.button4).setOnClickListener(listener);
        findViewById(R.id.button5).setOnClickListener(listener);
        findViewById(R.id.button6).setOnClickListener(listener);
        findViewById(R.id.button7).setOnClickListener(listener);
        findViewById(R.id.button8).setOnClickListener(listener);
        findViewById(R.id.button9).setOnClickListener(listener);
        findViewById(R.id.buttonDot).setOnClickListener(listener);
    }
    private void setOperatorButtonClickListener() {
        View.OnClickListener operatorListener = v -> {
            Button button = (Button) v;
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                operator = button.getText().toString();
                currentInput = "";
            }
        };

        findViewById(R.id.buttonAdd).setOnClickListener(operatorListener);
        findViewById(R.id.buttonSubtract).setOnClickListener(operatorListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(operatorListener);
        findViewById(R.id.buttonDivide).setOnClickListener(operatorListener);
        findViewById(R.id.buttonEqual).setOnClickListener(v -> {
            if (!currentInput.isEmpty()) {
                double secondNumber = Double.parseDouble(currentInput);
                double result;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = secondNumber != 0 ? firstNumber / secondNumber : 0; // Avoid division by zero
                        break;
                    default:
                        return;
                }
                resultText.setText(String.valueOf(result));
                currentInput = "";
            }
        });
    }
}

