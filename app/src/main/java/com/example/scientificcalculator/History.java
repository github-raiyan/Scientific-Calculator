package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Vector;

public class History extends AppCompatActivity {
    List<Button>buttons=new Vector<>(8);
    static List<List<String>> history = MainActivity.history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        buttons.add(findViewById(R.id.bt1));
        buttons.add(findViewById(R.id.btn2));
        buttons.add(findViewById(R.id.btn3));
        buttons.add(findViewById(R.id.btn4));
        buttons.add(findViewById(R.id.btn5));
        buttons.add(findViewById(R.id.btn6));
        buttons.add(findViewById(R.id.btn7));
        buttons.add(findViewById(R.id.btn8));
        setBtn();
    }

    void setBtn(){
        for(int j=0, i=history.size()-1; i>=0&&j<8; i--,j++){
            Button b=buttons.get(j);
            List<String>v=history.get(i);
            if(v.size()>0)
                b.setText(""+firtsPartOfEquation(v)+" .... = "+v.get(v.size()-1));
        }
    }
    String firtsPartOfEquation(List<String>v){
        String str="";
        for(int i=0;i<=4&&i<v.size()-1;i++){
            str+=v.get(i);
        }
        return str;
    }

    public void btn1(View view) {
        int index=history.size()-1;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn2(View view) {
        int index=history.size()-2;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn3(View view) {
        int index=history.size()-3;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn4(View view) {
        int index=history.size()-4;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn5(View view) {
        int index=history.size()-5;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn6(View view) {
        int index=history.size()-6;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn7(View view) {
        int index=history.size()-7;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }

    public void btn8(View view) {
        int index=history.size()-8;
        if(index<history.size()&&index>=0){
            callMain(history.get(index));
        }
    }
    void callMain(List<String>v){
        v.remove(v.size()-1);//stores result
        MainActivity.equation=v;
        MainActivity.input_txt.setText(setText(v));
        MainActivity.output_txt.setText("");
        Intent intent=new Intent(this,MainActivity.class);
        //startActivity(intent);
        //finish();
        super.onBackPressed();
    }
    String  setText(List<String >v){
        String str="";
        for(int i=0;i<v.size();i++){
            str+=v.get(i);
        }
        return  str;
    }
}