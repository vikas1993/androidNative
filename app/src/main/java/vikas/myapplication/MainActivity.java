package vikas.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private EditText fibNo;
    private AppCompatButton NativeCall,JavaCall;
    private TextView result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        this.fibNo = (EditText)findViewById(R.id.fibNo);
        this.NativeCall = (AppCompatButton) findViewById(R.id.NativeCall);
        this.JavaCall = (AppCompatButton)findViewById(R.id.JavaCall);
        this.result_text = (TextView) findViewById(R.id.result_text);

        //setting click listeners
        NativeCall.setOnClickListener(this);
        JavaCall.setOnClickListener(this);


    }


    @Override
    public void onClick(final View view) {
        String fibN = fibNo.getText().toString();
        if(fibN.isEmpty()){
            return;
        }
        final long fibNLong = Long.parseLong(fibN);
        final ProgressDialog dialog = ProgressDialog.show(this,"Calculating....","Wait",true);
        new AsyncTask<Void,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                dialog.dismiss();
                result_text.setText(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                String text = "";
                switch (view.getId()){

                    case R.id.NativeCall:
                        long startTime2 = System.currentTimeMillis();
                        long fibT = FibLib.fibNR(fibNLong);
                        text = "Native Call: "+fibT + "\n Executed in "+(System.currentTimeMillis() - startTime2)+"ms";
                        break;
                    case R.id.JavaCall:
                        long startTime = System.currentTimeMillis();
                        long fibTJ = FibLib.fibJR(fibNLong);
                        text = "JAVA Call: "+fibTJ + "\n Executed in "+(System.currentTimeMillis() - startTime)+"ms";
                        break;

                }
                return text;
            }
        }.execute();

    }


}
