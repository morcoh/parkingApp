package myfirstapp.morcohen.com;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    EditText eText;
    Button btn;
    Button login;
    Boolean mlsBlue;
    Intent i;
    EditText myNameText;
    EditText myPasswordText;
    String myName;
    String myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.editText);
        final String str = eText.getText().toString();

        btn = (Button)findViewById(R.id.mybutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                myNameText = (EditText)findViewById(R.id.editText);
                myName = myNameText.getText().toString();
                myPasswordText = (EditText)findViewById(R.id.editText2);
                myPassword = myPasswordText.getText().toString();

                if(myName.length()<1){


                }
                SQLiteDatabase subs = openOrCreateDatabase("Subscribers",MODE_PRIVATE,null);
                subs.execSQL("CREATE TABLE IF NOT EXISTS Subscribers(Username TEXT,Password TEXT);");
                subs.execSQL("INSERT INTO Subscribers VALUES('"+myName+"', '"+myPassword+"');");

                eText = (EditText) findViewById(R.id.editText);
                final String str = eText.getText().toString();
                Intent i = new Intent(MainActivity.this , ChooseActivity.class);
                i.putExtra("SubscriberName", str);
                startActivity(i);

            }



        });
        login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this , Login.class);
                //i.putExtra("SubscriberName", str);
                startActivity(i);

            }



        });


    }


//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putString(savedName, name);
//    }

//    public void change_color(View view) {
//        editText2.setBackgroundResource(R.color.blue);
//    }

    public void change_color(View view){


    }
    JSONObject jsonobject;


}

