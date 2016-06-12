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

public class BathroomActivity extends Activity {
    static String TAG = "Showering Activity";
    EditText editShower,editFaucet,editBath,editToilet ;
    int showers,baths,toiletFlushes,faucets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        Log.i(TAG, "Application is running");

        Button btn1 = (Button)(findViewById(R.id.showering));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newShower(v);
            }
        });

        editShower = (EditText) (findViewById(R.id.editTextShower));
        editFaucet = (EditText) (findViewById(R.id.editTextFaucet));
        editBath = (EditText) (findViewById(R.id.editTextBath));
        editToilet = (EditText) (findViewById(R.id.editTextToilet));


        Button btn3 = (Button)(findViewById(R.id.faucet));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newFaucet(v);
            }
        });

        Button btn4 = (Button)(findViewById(R.id.toilet));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newToilet(v);
            }
        });

        Button btn5 = (Button)(findViewById(R.id.bath));
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newBath(v);
            }
        });

        Button btn6 = (Button)(findViewById(R.id.dashboard));
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                newScreen(v);
            }
        });
    }

    public void newShower(View view){
        editShower.setVisibility(EditText.VISIBLE);
        showers = Integer.parseInt(editShower.getText().toString());
    }

    public void newToilet(View view){
        editToilet.setVisibility(EditText.VISIBLE);
        toiletFlushes = Integer.parseInt(editToilet.getText().toString());
    }

    public void newBath(View view){
        editBath.setVisibility(EditText.VISIBLE);
        baths = Integer.parseInt(editBath.getText().toString());
    }

    public void newFaucet(View view){
        editFaucet.setVisibility(EditText.VISIBLE);
        faucets = Integer.parseInt(editFaucet.getText().toString());
    }



    public void newScreen (View view)
    {
        Intent startNewActivity = new Intent(this, DashboardActivity.class);
        startActivity(startNewActivity);
    }
}

