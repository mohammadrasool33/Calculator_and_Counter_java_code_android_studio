package com.example.numwise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Counter extends AppCompatActivity {
    Button count_button;
    Button reset_button;
    TextView text_counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);

        count_button=findViewById(R.id.counter_button);
        reset_button=findViewById(R.id.reset_button);
        text_counter=findViewById(R.id.text_counter);

        count_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(text_counter.getText().toString());
                count++;

                text_counter.setText(""+count);
            }
        });
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_counter.setText(""+0);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();

        if(itemId==R.id.home){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        else if (itemId==R.id.about_us){
            Intent i=new Intent(getApplicationContext(), AboutUs.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}