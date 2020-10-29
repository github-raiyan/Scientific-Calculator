package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
public class MainActivity extends AppCompatActivity {
    static List<String> equation = new Vector<>();
    static List<List<String>> history = new Vector<>();
    List<String> cpy = new Vector<String>();
    boolean isInv=false;
    double ansVal=0;
    static TextView input_txt;
    static TextView output_txt;
    Button sin_btn,cos_btn,tan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input_txt=findViewById(R.id.input_txt);
        output_txt=findViewById(R.id.output_txt);
        sin_btn=findViewById(R.id.sin_btn);
        cos_btn=findViewById(R.id.cos_btn);
        tan_btn=findViewById(R.id.tan_btn);

    }

    public void history(View view) {
        Intent intent=new Intent(this,History.class);
        startActivity(intent);
    }

    public void about(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Developed by:\nMd Raiyan Hossain\nID: 173-15-10258";
        int duration = Toast.LENGTH_LONG;

        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void printOnDisplay(){
        String str="";
        for(int i=0;i<equation.size();i++){
            str+=equation.get(i);
        }
        input_txt.setText(str);
    }


    public void inv(View view) {

        if(isInv){
            sin_btn.setText("sin");
            cos_btn.setText("cos");
            tan_btn.setText("tan");

            sin_btn.setBackground(getDrawable(R.drawable.round_button));
            cos_btn.setBackground(getDrawable(R.drawable.round_button));
            tan_btn.setBackground(getDrawable(R.drawable.round_button));
            isInv=false;
        }
        else{
            sin_btn.setText("sin^-1");
            cos_btn.setText("cos^-1");
            tan_btn.setText("tan^-1");

            sin_btn.setBackground(getDrawable(R.drawable.inv_color));
            cos_btn.setBackground(getDrawable(R.drawable.inv_color));
            tan_btn.setBackground(getDrawable(R.drawable.inv_color));
            isInv=true;
        }
    }

    public void log(View view) {
        equation.add("log(");
        printOnDisplay();
    }

    public void strtBrackt(View view) {
        equation.add("(");
        printOnDisplay();
    }

    public void clsBracket(View view) {
        equation.add(")");
        printOnDisplay();
    }

    public void nPr(View view) {
        equation.add("P");
        printOnDisplay();
    }

    public void nCr(View view) {
        equation.add("C");
        printOnDisplay();
    }

    public void sin(View view) {
        if(!isInv){
            equation.add("sin(");
        }
        else{
            equation.add("sin^-1(");
        }

        printOnDisplay();
    }

    public void ln(View view) {
        equation.add("ln(");
        printOnDisplay();
    }

    public void root(View view) {
        equation.add("√");
        printOnDisplay();
    }

    public void power(View view) {
        equation.add("^");
        printOnDisplay();
    }

    public void cos(View view) {
        if(!isInv){
            equation.add("cos(");
        }
        else {
            equation.add("cos^-1(");
        }

        printOnDisplay();
    }

    public void tan(View view) {
        if(!isInv){
            equation.add("tan(");
        }
        else{
            equation.add("tan^-1(");
        }

        printOnDisplay();
    }

    public void pi(View view) {
        equation.add("π");
        printOnDisplay();
    }

    public void fact(View view) {
        equation.add("!");
        printOnDisplay();
    }

    public void xsquare(View view) {
        equation.add("^2");
        printOnDisplay();
    }

    public void xinv(View view) {
        equation.add("^-1");
        printOnDisplay();
    }

    public void seven(View view) {
        equation.add("7");
        printOnDisplay();
    }

    public void eight(View view) {
        equation.add("8");
        printOnDisplay();
    }

    public void nine(View view) {
        equation.add("9");
        printOnDisplay();
    }

    public void del(View view) {
        equation.remove(equation.size()-1);
        printOnDisplay();
    }

    public void ac(View view) {
        equation.clear();
        input_txt.setText("");
        output_txt.setText("");
        //printOnDisplay();
    }

    public void four(View view) {
        equation.add("4");
        printOnDisplay();
    }

    public void five(View view) {
        equation.add("5");
        printOnDisplay();
    }

    public void six(View view) {
        equation.add("6");
        printOnDisplay();
    }

    public void mul(View view) {
        equation.add("X");
        printOnDisplay();
    }

    public void div(View view) {
        equation.add("÷");
        printOnDisplay();
    }

    public void one(View view) {
        equation.add("1");
        printOnDisplay();
    }

    public void two(View view) {
        equation.add("2");
        printOnDisplay();
    }

    public void three(View view) {
        equation.add("3");
        printOnDisplay();
    }

    public void add(View view) {
        equation.add("+");
        printOnDisplay();
    }

    public void sub(View view) {
        equation.add("-");
        printOnDisplay();
    }

    public void zero(View view) {
        equation.add("0");
        printOnDisplay();
    }

    public void point(View view) {
        equation.add(".");
        printOnDisplay();
    }

    public void ans(View view) {
        equation.clear();
        input_txt.setText("");
        output_txt.setText("");
        equation.add("Ans");
        printOnDisplay();

    }

    public void equal(View view) {


        String str="";
        for(int i=0;i<equation.size();i++){
            if(equation.get(i).equals("Ans")){
                equation.set(i,""+ansVal);

            }
            str+=equation.get(i);
        }
        Brain brain=new Brain(str);
        if(!brain.hasValidBrackets()){
            error("Syntax Error!!");
        }
        else{
            try {
                String result=brain.result();
                DecimalFormat df2 = new DecimalFormat("#.####");
                result=""+df2.format(Double.parseDouble(result));
                output_txt.setText(result);
                ansVal=Double.parseDouble(result);
                cpy = new Vector<String>(equation);
                //Collections.copy(cpy,equation);
                cpy.add(result);
                history.add(cpy);
                equation.clear();
                System.out.println(history);
            }
            catch (Exception e){
                System.out.println("Failed");
                error("Math Error!!");
            }
        }
    }
    private void error(String str){
        //equation.clear();
        //input_txt.setText("");
        output_txt.setText("");
        output_txt.setText(str);
    }
}