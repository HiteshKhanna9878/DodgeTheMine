package com.example.dodgemine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    int[] rands;
    Button[] buttons;
    int count;
    int p;
    int sec;
    boolean timer;
    int no_of_Mines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no_of_Mines = intent.getIntExtra("level",5);
        rands = new int[no_of_Mines];
        setButtons();
        startTimer();
        timer = true;
        count =0;
    }
    public void setButtons()
    {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<no_of_Mines;i++)
        {
            int temp = (int)(64*Math.random());
            while(hashSet.contains(temp))
            {
                temp = (int)(64*Math.random());
            }
            rands[i] = temp;
            hashSet.add(temp);
        }
        buttons = new Button[64];
        buttons[0] = findViewById(R.id.b1);
        buttons[1] = findViewById(R.id.b2);
        buttons[2] = findViewById(R.id.b3);
        buttons[3] = findViewById(R.id.b4);
        buttons[4] = findViewById(R.id.b5);
        buttons[5] = findViewById(R.id.b6);
        buttons[6] = findViewById(R.id.b7);
        buttons[7] = findViewById(R.id.b8);
        buttons[8] = findViewById(R.id.b9);
        buttons[9] = findViewById(R.id.b10);
        buttons[10] = findViewById(R.id.b11);
        buttons[11] = findViewById(R.id.b12);
        buttons[12] = findViewById(R.id.b13);
        buttons[13] = findViewById(R.id.b14);
        buttons[14] = findViewById(R.id.b15);
        buttons[15] = findViewById(R.id.b16);
        buttons[16] = findViewById(R.id.b17);
        buttons[17] = findViewById(R.id.b18);
        buttons[18] = findViewById(R.id.b19);
        buttons[19] = findViewById(R.id.b20);
        buttons[20] = findViewById(R.id.b21);
        buttons[21] = findViewById(R.id.b22);
        buttons[22] = findViewById(R.id.b23);
        buttons[23] = findViewById(R.id.b24);
        buttons[24] = findViewById(R.id.b25);
        buttons[25] = findViewById(R.id.b26);
        buttons[26] = findViewById(R.id.b27);
        buttons[27] = findViewById(R.id.b28);
        buttons[28] = findViewById(R.id.b29);
        buttons[29] = findViewById(R.id.b30);
        buttons[30] = findViewById(R.id.b31);
        buttons[31] = findViewById(R.id.b32);
        buttons[32] = findViewById(R.id.b33);
        buttons[33] = findViewById(R.id.b34);
        buttons[34] = findViewById(R.id.b35);
        buttons[35] = findViewById(R.id.b36);
        buttons[36] = findViewById(R.id.b37);
        buttons[37] = findViewById(R.id.b38);
        buttons[38] = findViewById(R.id.b39);
        buttons[39] = findViewById(R.id.b40);
        buttons[40] = findViewById(R.id.b41);
        buttons[41] = findViewById(R.id.b42);
        buttons[42] = findViewById(R.id.b43);
        buttons[43] = findViewById(R.id.b44);
        buttons[44] = findViewById(R.id.b45);
        buttons[45] = findViewById(R.id.b46);
        buttons[46] = findViewById(R.id.b47);
        buttons[47] = findViewById(R.id.b48);
        buttons[48] = findViewById(R.id.b49);
        buttons[49] = findViewById(R.id.b50);
        buttons[50] = findViewById(R.id.b51);
        buttons[51] = findViewById(R.id.b52);
        buttons[52] = findViewById(R.id.b53);
        buttons[53] = findViewById(R.id.b54);
        buttons[54] = findViewById(R.id.b55);
        buttons[55] = findViewById(R.id.b56);
        buttons[56] = findViewById(R.id.b57);
        buttons[57] = findViewById(R.id.b58);
        buttons[58] = findViewById(R.id.b59);
        buttons[59] = findViewById(R.id.b60);
        buttons[60] = findViewById(R.id.b61);
        buttons[61] = findViewById(R.id.b62);
        buttons[62] = findViewById(R.id.b63);
        buttons[63] = findViewById(R.id.b64);
        for(int i:rands)
        {
            buttons[i].setBackgroundColor(getColor(R.color.red));
            buttons[i].setTag("-1");
            buttons[i].setClickable(false);
        }
        makeUnClickAble();
    }
    public void turnGreen(View view)
    {
        String tag = (String) ((Button) view).getTag();
        if (!tag.equals("-1")) {
            ((Button) view).setBackgroundColor(getColor(R.color.green));
            count++;
            ((Button)view).setClickable(false);
            if(count==64-no_of_Mines)
                win();
        }
        else {
            Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show();
            Button play_agn = (Button) findViewById(R.id.again);
            play_agn.setVisibility(View.VISIBLE);
            play_agn.setBackgroundColor(getColor(R.color.dark_red));
            afterLoss();
        }
    }
    public void startTimer()
    {
        sec = 0;
        new Thread(){
            public void run() {
                while(sec<=10)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)(findViewById(R.id.textView))).setText((10-sec)+"");
                            sec++;
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                setColor();
                sec =0;
                while(timer)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)(findViewById(R.id.textView))).setText(sec+"");
                            sec++;
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                sec =0;
                timer = true;
            }
        }.start();

    }
    public void setColor()
    {
        for(p=0;p<64;p++)
        {
            buttons[p].setBackgroundColor(getColor(R.color.blue));
            buttons[p].setClickable(true);
        }
        p=0;
    }
    public void afterLoss()
    {
        for(p=0;p<64;p++)
        {
            buttons[p].setClickable(false);
            String tag = (String)(buttons[p].getTag());
            if(tag.equals("-1"))
            {
                buttons[p].setBackgroundColor(getColor(R.color.red));
            }
            else {
                buttons[p].setBackgroundColor(getColor(R.color.green));
            }
            buttons[p].setTag("1");
        }
        p=0;
        timer = false;
    }
    public void playAgain(View view)
    {
        Button play_Button =(Button)findViewById(R.id.again);
        play_Button.setVisibility(View.INVISIBLE);
        count = 0;
        setColor();
        setButtons();
        startTimer();
    }
    public void win()
    {
        Button play_Button =(Button)findViewById(R.id.again);
        play_Button.setVisibility(View.VISIBLE);
        play_Button.setBackgroundColor(getColor(R.color.green));
        Toast.makeText(this, "Hurrah, You won", Toast.LENGTH_SHORT).show();
        for(p=0;p<64;p++)
        {
            buttons[p].setClickable(false);
            String tag = (String)(buttons[p].getTag());
            if(tag.equals("-1"))
            {
                buttons[p].setBackgroundColor(getColor(R.color.black));
            }
            buttons[p].setTag("1");
        }
        p=0;
        timer = false;
    }
    public void start_Home_Page(View view)
    {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        MainActivity.this.startActivity(intent);
    }
    public void makeUnClickAble()
    {
        for(p=0;p<64;p++)
        {
            buttons[p].setClickable(false);
        }
        p=0;
    }
}