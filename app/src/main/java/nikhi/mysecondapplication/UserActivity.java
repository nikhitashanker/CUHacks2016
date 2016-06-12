package nikhi.mysecondapplication;

/**
 * Created by nikhi on 6/10/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText edit2,edit3;
    int washes, meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.buttonWash));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDisplayWash(v);
            }
        });

        edit2 = (EditText) (findViewById(R.id.editText2));
        edit3 = (EditText) (findViewById(R.id.editText3));

        Button btn3 = (Button)(findViewById(R.id.buttonCook));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newDisplayCook(v);
            }
        });

        Button btn4 = (Button)(findViewById(R.id.buttonD));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });

    }

    public void newDisplayWash(View view){
        edit2.setVisibility(EditText.VISIBLE);
        washes = Integer.parseInt(edit2.getText().toString());
    }

    public void newDisplayCook(View view)
    {
        edit3.setVisibility(EditText.VISIBLE);
        meals = Integer.parseInt(edit3.getText().toString());
    }

    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startActivity(startNewActivity);
    }
}

