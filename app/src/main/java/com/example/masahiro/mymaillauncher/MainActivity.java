package com.example.masahiro.mymaillauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private String to = "";
    private String titleMessage = "";
    private String mainMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                int value = radioButton.getId();
                //メールを選択された時の処理
                ImageView image = (ImageView) findViewById(R.id.image);
                switch(value){
                    case R.id.MailA:
                        image.setImageResource(R.drawable.ken);
                        to = radioButton.getText().toString();
                        break;

                    case R.id.MailB:
                        image.setImageResource(R.drawable.raou);
                        to = radioButton.getText().toString();
                        break;

                    case R.id.MailC:
                        image.setImageResource(R.drawable.sin);
                        to = radioButton.getText().toString();
                        break;
                }
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText et = (EditText) findViewById(R.id.title);
                titleMessage = et.getText().toString();
                EditText et2 = (EditText) findViewById(R.id.article);
                mainMessage = et2.getText().toString();

                Uri uri = Uri.parse("mailto:" + to);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, titleMessage);
                intent.putExtra(Intent.EXTRA_TEXT, mainMessage);
                startActivity(intent);
            }
        });
    }
}
