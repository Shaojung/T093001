package tw.com.pcschool.t093001;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
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

        ImageRequest req2 = new ImageRequest("http://www.pcschool.com.tw/updimg/mbrpdt/636104311716853339_B.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER , Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
        queue.add(req2);
        queue.start();
    }
}
