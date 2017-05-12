package myfirstapp.morcohen.com;


        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.TextView;

        import org.w3c.dom.Text;
/**
 * Created by User on 26/02/17.
 */



public class Login extends AppCompatActivity {

    Button start;
    String myName;
    String myPassword;
    TextView error;
    EditText myNameText;
    EditText myPasswordText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);


    start = (Button)findViewById(R.id.button);
    start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myNameText = (EditText)findViewById(R.id.Name);
                myName = myNameText.getText().toString();
                myPasswordText = (EditText)findViewById(R.id.Password);
                myPassword = myPasswordText.getText().toString();
                error = (TextView)findViewById(R.id.error);

                SQLiteDatabase subs = openOrCreateDatabase("Subscribers",MODE_PRIVATE,null);
                subs.execSQL("CREATE TABLE IF NOT EXISTS Subscribers(Username TEXT,Password TEXT);");
                subs.execSQL("INSERT INTO Subscribers VALUES('admin','admin');");
                //Cursor cursor = subs.rawQuery("SELECT * FROM Subscribers WHERE Username='admin';", null);
                //String a = cursor.getString(0);
               // Cursor resultSet = subs.rawQuery("Select * from Subscribers WHERE Username = 'admin'",null);

                Cursor resultSet = subs.rawQuery("Select * from Subscribers WHERE Username='"+myName+"' and Password='"+myPassword+"';",null);


                //error.setText(myName);
                if(resultSet.getCount() == 0){

                    error.setVisibility(TextView.VISIBLE);
                }

                else {
                    resultSet.moveToFirst();
                    String username = resultSet.getString(0);
                    String password = resultSet.getString(1);

                    final String str = username.toString();
                    Intent i = new Intent(Login.this , ChooseActivity.class);
                    i.putExtra("SubscriberName", str);
                    startActivity(i);

                }

            }
    });

}
}
