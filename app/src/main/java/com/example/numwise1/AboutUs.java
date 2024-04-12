package com.example.numwise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AboutUs extends AppCompatActivity {
    Button showInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);

        showInfo=findViewById(R.id.show_information);

        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment secondFragment = new FirstFragment();
                secondFragment.setArguments(getIntent().getExtras());
                FragmentManager fragManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.add(R.id.frameLayout, secondFragment);
                transaction.commit();
            }
        });



    }
    @Override
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
        else if(itemId==R.id.counter){
            Intent i=new Intent(getApplicationContext(),Counter.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}