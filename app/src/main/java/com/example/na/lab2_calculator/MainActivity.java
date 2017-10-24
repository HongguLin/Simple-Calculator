package com.example.na.lab2_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class MainActivity extends AppCompatActivity {


    String display = "";
    TextView dtv;
    private int weight;
    Subs subs = new Subs();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics displayMatics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMatics);
        weight = displayMatics.widthPixels;

        dtv = (TextView)findViewById(R.id.dispalytextView);
        dtv.setText("0");

        Button b0 = (Button)findViewById(R.id.btn0);
        ViewGroup.LayoutParams params = b0.getLayoutParams();
        params.width = weight/4-20;
        b0.setLayoutParams(params);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "0";
                dtv.setText(display);
            }
        });
        Button b1 = (Button)findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "1";
                dtv.setText(display);
            }
        });
        Button b2 = (Button)findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "2";
                dtv.setText(display);
            }
        });
        Button b3 = (Button)findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "3";
                dtv.setText(display);
            }
        });
        Button b4 = (Button)findViewById(R.id.btn4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "4";
                dtv.setText(display);
            }
        });
        Button b5 = (Button)findViewById(R.id.btn5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "5";
                dtv.setText(display);
            }
        });
        Button b6 = (Button)findViewById(R.id.btn6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "6";
                dtv.setText(display);
            }
        });
        Button b7 = (Button)findViewById(R.id.btn7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "7";
                dtv.setText(display);
            }
        });
        Button b8 = (Button)findViewById(R.id.btn8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "8";
                dtv.setText(display);
            }
        });
        Button b9 = (Button)findViewById(R.id.btn9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "9";
                dtv.setText(display);
            }
        });

        Button bplus = (Button)findViewById(R.id.btnplus);
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "+";
                dtv.setText(display);
            }
        });
        Button bminus = (Button)findViewById(R.id.btnminus);
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "-";
                dtv.setText(display);
            }
        });
        Button bmultiply = (Button)findViewById(R.id.btnmultiply);
        bmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "*";
                dtv.setText(display);
            }
        });
        Button bdivide = (Button)findViewById(R.id.btndivide);
        bdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "/";
                dtv.setText(display);
            }
        });

        Button bequal = (Button)findViewById(R.id.btnequal);
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display != "X") {
                    Tokenizer tok = new SimpleTokenizer(display);
                    Exp exp = Exp.parseExp(tok);
                    //subs.put("X", 1);
                    int rs = exp.evaluate(subs);
                    String t = "" + rs;
                    display = display + "=" + t;
                    dtv.setText(display);

                    File path = getFilesDir();
                    System.out.println(path);
                    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = Calendar.getInstance().getTime();
                    String dates = sdf.format(date);
                    File file = new File(path, "data.json");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("log", display);
                    jsonObject.put("date", dates);
                    FileWriter out;
                    try {
                        out = new FileWriter(file);
                        jsonObject.writeJSONString(out);
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("in else loop");
                    display += "=";
                    dtv.setText(display);
                }


            }
        });

        Button bclear = (Button)findViewById(R.id.btnclear);
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display = "";
                dtv.setText("0");
            }
        });

        Button help = (Button)findViewById(R.id.btnhelp);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, NewActivity.class);
                startActivity(intent);

            }
        });

        Button X = (Button)findViewById(R.id.btnX);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "X";
                dtv.setText(display);
            }
        });

        Button assign = (Button)findViewById(R.id.btnassign);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tokenizer tok = new SimpleTokenizer(display);
                Exp exp = Exp.parseExp(tok);
                //subs.put("X", 1);
                int rs = exp.evaluate(subs);
                subs.put("X", rs);

            }
        });


        Button clearfile = (Button) findViewById(R.id.btnclearfile);
        clearfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = getFilesDir();

                File file = new File(path,"data.json");
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("log","");
                jsonObject.put("date","");
                FileWriter out;
                try {
                    out = new FileWriter(file);
                    jsonObject.writeJSONString(out);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Button left = (Button)findViewById(R.id.btnleft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += "(";
                dtv.setText(display);
            }
        });

        Button right = (Button)findViewById(R.id.btnright);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display += ")";
                dtv.setText(display);
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {

            case R.id.menu_save:
                Toast.makeText(MainActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                File path = getFilesDir();
                File file = new File(path,"data.json");
                try {
                    JSONObject jsonObject = (JSONObject) JSONValue.parse(new FileReader(file));
                    String log = (String) jsonObject.get("log");
                    String dates = (String) jsonObject.get("date");

                    dtv.setText(log);
                    System.out.println(dates);
                    System.out.println(log);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
