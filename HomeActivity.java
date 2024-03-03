package com.example.dodgemine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class HomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
    }
    public void add(View view)
    {

        EditText level = (EditText)findViewById(R.id.dif);
        int setter = Integer.parseInt(level.getText().toString())+1;
        if(setter<=32)
            level.setText(setter+"");
        else
            Toast.makeText(this, "Max level is 32", Toast.LENGTH_SHORT).show();
    }
    public void sub(View view)
    {
        EditText level = (EditText)findViewById(R.id.dif);
        int setter = Integer.parseInt(level.getText().toString())-1;
        if(setter>=1)
            level.setText(setter+"");
        else
            Toast.makeText(this, "Min level is 1", Toast.LENGTH_SHORT).show();
    }
    public void startGame(View view)
    {
        EditText level = (EditText)findViewById(R.id.dif);
        int current = Integer.parseInt(level.getText().toString());
        if((current<=32)&&(current>=1))
        {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.putExtra("level",current);
            HomeActivity.this.startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Difficulty range is from 1 to 32", Toast.LENGTH_SHORT).show();
        }
    }
}
