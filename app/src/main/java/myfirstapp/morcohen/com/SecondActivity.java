package myfirstapp.morcohen.com;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Text;

/**
 * Created by User on 05/02/17.
 */

public class SecondActivity extends AppCompatActivity {

    //private SQLiteDatabase subs;
    TextView SubscriberName;
    Text a;
    Intent in;
    TextView Password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent in = getIntent();
        //intb = new Intent(SecondActivity.this, MainActivity.class);
        String tv1= in.getExtras().getString("SubscriberName");

        SubscriberName = (TextView)findViewById(R.id.subscribername2);

        SubscriberName.setText(SubscriberName.getText() + tv1);

       SQLiteDatabase subs = openOrCreateDatabase("Subscribers",MODE_PRIVATE,null);

        subs.execSQL("CREATE TABLE IF NOT EXISTS Subscribers(Username VARCHAR,Password VARCHAR);");
        subs.execSQL("INSERT INTO Subscribers VALUES('admin','admin');");
        //Cursor cursor = subs.rawQuery("SELECT * FROM Subscribers WHERE Username='admin';", null);
        //String a = cursor.getString(0);
        Cursor resultSet = subs.rawQuery("Select * from Subscribers",null);
        resultSet.moveToFirst();
        String username = resultSet.getString(0);
        String password = resultSet.getString(1);

        Password = (TextView)findViewById(R.id.centertext);
        Password.setText((Password.getText()+username));




    }






}
