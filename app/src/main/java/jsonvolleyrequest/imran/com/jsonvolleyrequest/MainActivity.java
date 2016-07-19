package jsonvolleyrequest.imran.com.jsonvolleyrequest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {


    private String UrlJsonObj = "http://api.androidhive.info/volley/person_object.json";
    private String UrlJsonArray = "http://api.androidhive.info/volley/person_array.json";

    private static String TAG = MainActivity.class.getSimpleName();
    private Button btnMakeObjectRequest, btnMakeArrayRequest;

    private ProgressDialog mDialog;
    private TextView mTextView;

    private String textResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMakeObjectRequest = (Button) findViewById(R.id.btnObjRequest);
        btnMakeArrayRequest = (Button) findViewById(R.id.btnArrayRequest);
        TextView txtResponse = (TextView) findViewById(R.id.txtResponse);


        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Please wait...");
        mDialog.setCancelable(false);

        btnMakeObjectRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }

        });

        btnMakeArrayRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArrayRequest();
            }

        });


    }

    private void showDialog() {
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    private void hideDialog() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


    private void makeJsonObjectRequest() {
        showDialog();
        //Toast.makeText(MainActivity.this, "sfd", Toast.LENGTH_LONG).show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, UrlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
    });

    private void makeJsonArrayRequest() {
    }
}
