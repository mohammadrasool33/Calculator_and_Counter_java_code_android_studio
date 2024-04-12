package com.example.numwise1;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.util.*;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button shareBtn;
    FrameLayout frameLayout;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.textView);

        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

        shareBtn=findViewById(R.id.share_btn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text");
                String result=display.getText().toString();
                i.putExtra(Intent.EXTRA_SUBJECT,"Result");
                i.putExtra(Intent.EXTRA_TEXT,result);
                if(!display.getText().toString().equals("") && !display.getText().toString().equals("Enter a value")) {
                    startActivity(Intent.createChooser(i,"choose a platform"));
                }
                else {
                    Toast.makeText(getApplicationContext(),"The Result is Null",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();
        if (itemId==R.id.about_us){
            Intent i=new Intent(getApplicationContext(),AboutUs.class);
            startActivity(i);
        }
        else if(itemId==R.id.counter){
            Intent i=new Intent(getApplicationContext(),Counter.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void zeroBtn(View view){
        updateDisplay("0");
    }
    public void oneBtn(View view){
        updateDisplay("1");
    }
    public void twoBtn(View view){
        updateDisplay("2");
    }
    public void threeBtn(View view){
        updateDisplay("3");
    }
    public void fourBtn(View view){
        updateDisplay("4");
    }
    public void fiveBtn(View view){
        updateDisplay("5");
    }
    public void sixBtn(View view){
        updateDisplay("6");
    }
    public void sevenBtn(View view){
        updateDisplay("7");
    }
    public void eightBtn(View view){
        updateDisplay("8");
    }
    public void nineBtn(View view){
        updateDisplay("9");
    }
    public void addBtn(View view){
        updateDisplay("+");
    }
    public void subtractBtn(View view){
        updateDisplay("-");
    }
    public void divideBtn(View view){
        updateDisplay("/");
    }
    public void multiplyBtn(View view){
        updateDisplay("*");
    }
    public void clearBtn(View view){
        display.setText("");
    }
    public void pointBtn(View view){
        updateDisplay(".");
    }
    public void exponentBtn(View view){

    }
    public void parenthesisBtn(View view){
        int currentPosition=display.getSelectionStart();
        int openPar=0;
        int closePar=0;
        int textLength=display.getText().toString().length();
        for (int i=0;i<currentPosition;i++){
            if (display.getText().toString().substring(i,i+1).equals("(")){
                openPar+=1;
            }
            if (display.getText().toString().substring(i,i+1).equals(")")){
                closePar+=1;
            }
        }
        if (openPar==closePar || display.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateDisplay("(");

        }
        else if (openPar<closePar && !display.getText().toString().substring(textLength-1,textLength).equals("(")){
            updateDisplay(")");

        }
        display.setSelection(currentPosition+1);
    }
    public void equalBtn(View view){

    }
    public void backspaceBtn(View view){
        int currentPosition=display.getSelectionStart();
        int textLength=display.getText().toString().length();
        if (currentPosition!=0 && textLength!=0){
            SpannableStringBuilder selection=(SpannableStringBuilder)display.getText();
            selection.replace(currentPosition-1,currentPosition,"");
            display.setSelection(currentPosition-1);
        }
    }
    private void updateDisplay(String addString){
        String oldString=display.getText().toString();
        int currentPosition=display.getSelectionStart();
        String leftStr=oldString.substring(0,currentPosition);
        String rightStr=oldString.substring(currentPosition);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(addString);
        }
        else {
            display.setText(leftStr+addString+rightStr);
            display.setSelection(currentPosition+1);
        }
    }
}