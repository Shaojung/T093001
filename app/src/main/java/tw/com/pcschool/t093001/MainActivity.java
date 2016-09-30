package tw.com.pcschool.t093001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new MyUTF8StringRequest("http://udn.com/rssfeed/news/1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NET", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NET", error.toString());
            }
        });
        queue.add(request);
        queue.start();
    }
}
