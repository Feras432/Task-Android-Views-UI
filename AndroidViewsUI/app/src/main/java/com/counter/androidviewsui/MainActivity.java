package com.counter.androidviewsui;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean choice;

   public ArrayList<String> questions = new ArrayList<String>();
    TextView choiceTextView;
    Button choiceButton;

    questions.add("The color of the sky is blue.");
    questions.add("The color of the ground is brown.");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       choiceTextView = findViewById(R.id.choiceTextView);

       choiceButton = findViewById(R.id.choiceButton);
        choiceButton.setOnClickListener();

        choiceButton.setOnClickListener(v -> { choice = true;
            choiceTextView.setText(String.valueOf(choice));});
    }

}