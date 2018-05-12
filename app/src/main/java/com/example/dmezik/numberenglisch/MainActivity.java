package com.example.dmezik.numberenglisch;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int firstChislo;
    private int TwoChislo;
    private int SummaChisel;
    private String English;
    private String Neznayu;
    Vibrator v;
    private int lastchislo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNewNumbers();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        TextView EnglishName = findViewById(R.id.EnglishName);
        EnglishName.setText("");

    }

    public void ClickNew(View view) {
        generateNewNumbers();
    }

    public void generateNewNumbers() {
        firstChislo = (int) (Math.random() * 100);
        TwoChislo = (int) (Math.random() * 100);
        TextView Id1 = findViewById(R.id.number1);
        TextView Id2 = findViewById(R.id.number2);

        Id1.setText(Integer.toString(firstChislo));
        Id2.setText(Integer.toString(TwoChislo));
        SummaChisel = firstChislo + TwoChislo;
        TextView ChisloNumber = findViewById(R.id.summaChislo);
        ChisloNumber.setText(Integer.toString(SummaChisel));
        English = EnglishNumberToWords.convert(SummaChisel);
        System.out.println(Neznayu);
        System.out.println(English);


    }


    public void proberkaChisel() {
        EditText port = findViewById(R.id.RuText);
        Neznayu = port.getText().toString();

        if (Neznayu.equals(English)) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Поздравлеем ваше знание Английского языка на уровне перфект,можешь писать следующеее число",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            TextView EnglishName1 = findViewById(R.id.EnglishName);
            EnglishName1.setText("Последнее правильно написаное число: "+ English);
            generateNewNumbers();
            port.getText().clear();
            System.out.println(Neznayu);
            System.out.println(English);

        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "ТЫ тупой и написал все неправльно твой телефон взорвется через 3 секунды ",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            //VibrationEffect effect = VibrationEffect.createOneShot(1000, 2);
            //v.vibrate(effect);
            v.vibrate(100);
            port.getText().clear();
            System.out.println(Neznayu);
            System.out.println(English);
        }
    }

    public void OnClickProverka(View view) {
        proberkaChisel();
    }
}
