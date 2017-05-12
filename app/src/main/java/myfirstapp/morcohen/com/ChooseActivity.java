package myfirstapp.morcohen.com;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 05/03/17.
 */

public class ChooseActivity extends MainActivity {
    Button search;
    Button post;
    TextView myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);
        Intent in = getIntent();

        String tv1= in.getExtras().getString("SubscriberName");
        myName =(TextView)findViewById(R.id.hello);
        myName.setText(myName.getText() + tv1);


        SQLiteDatabase subs = openOrCreateDatabase("Subscribers",MODE_PRIVATE,null);
        subs.execSQL("CREATE TABLE IF NOT EXISTS Subscribers(Username TEXT,Password TEXT);");
        subs.execSQL("INSERT INTO Subscribers VALUES('admin','admin');");
        //Cursor cursor = subs.rawQuery("SELECT * FROM Subscribers WHERE Username='admin';", null);
        //String a = cursor.getString(0);
        // Cursor resultSet = subs.rawQuery("Select * from Subscribers WHERE Username = 'admin'",null);

        Cursor resultSet = subs.rawQuery("Select * from Subscribers WHERE Username='"+myName+"' and Password='"+myPassword+"';",null);

        post = (Button)findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseActivity.this, MapsActivity.class);
                //i.putExtra("SubscriberName", str);
                startActivity(i);

            }
        });
    }
}
