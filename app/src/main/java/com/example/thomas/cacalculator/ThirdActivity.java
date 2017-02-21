package com.example.thomas.cacalculator;

/**
 * Created by Thomas on 20/02/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity
{
    EditText firstMark;
    EditText secondMark;
    EditText firstPercent;

    TextView answer;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        firstMark = (EditText) findViewById(R.id.firstMark);
        firstMark.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3)});

        secondMark = (EditText) findViewById(R.id.secondMark);
        secondMark.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3)});

        firstPercent = (EditText) findViewById(R.id.firstPercent);
        firstPercent.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2)});

        firstPercent.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!String.valueOf(firstPercent.getText()).equals("") && !String.valueOf(firstPercent.getText()).equals(".") &&
                        !String.valueOf(firstMark.getText()).equals("") && !String.valueOf(secondMark.getText()).equals("") &&
                        !String.valueOf(firstMark.getText()).equals(".") && !String.valueOf(secondMark.getText()).equals("."))
                {
                    calculate();
                }
            }

            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub
            }
        });

        firstMark.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!String.valueOf(firstPercent.getText()).equals("") && !String.valueOf(firstPercent.getText()).equals(".") &&
                        !String.valueOf(firstMark.getText()).equals("") && !String.valueOf(secondMark.getText()).equals("") &&
                        !String.valueOf(firstMark.getText()).equals(".") && !String.valueOf(secondMark.getText()).equals("."))
                {
                    calculate();
                }
            }

            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub
            }
        });

        secondMark.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!String.valueOf(firstPercent.getText()).equals("") && !String.valueOf(firstPercent.getText()).equals(".") &&
                        !String.valueOf(firstMark.getText()).equals("") && !String.valueOf(secondMark.getText()).equals("") &&
                        !String.valueOf(firstMark.getText()).equals(".") && !String.valueOf(secondMark.getText()).equals("."))
                {
                    calculate();
                }
            }

            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id)
        {
            case R.id.item1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(this, SecondActivity.class);
                startActivity(intent2);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate()
    {
        boolean possible = true;

        answer = (TextView) findViewById(R.id.answer);

        float result = (Float.parseFloat(String.valueOf(firstMark.getText())) / Float.parseFloat(String.valueOf(secondMark.getText()))) * Float.parseFloat(String.valueOf(firstPercent.getText()));

        if (Float.parseFloat(String.valueOf(firstMark.getText())) > Float.parseFloat(String.valueOf(secondMark.getText())))
        {
            possible = false;
        }

        if (result <= 100 && possible)
        {
            answer.setText(String.valueOf(Math.round(result * 100.0) / 100.0) + "%");
        }
        else
        {
            answer.setText("Not Possible");
        }
    }
}
