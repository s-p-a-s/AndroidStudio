package request;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class Requests {


    public static String URL = "http://10.106.3.103:8000/spas/";

    public static String get(final Activity activity){
        return send(activity, Request.Method.GET);

    }
    public static String post(final Activity activity){
        return send(activity, Request.Method.POST);
    }
    public static String put(final Activity activity){
        return send(activity, Request.Method.PUT);

    }public static String delete(final Activity activity){
        return send(activity, Request.Method.DELETE);
    }


    public static String send(final Activity activity, int request ){

        RequestQueue requestQueue = Volley.newRequestQueue(activity.getApplicationContext());

        StringRequest jsonObjectRequest = new StringRequest(request, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("HttpClient", "success! response: " + response);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "error: " + error.toString());

                    }
                });
        String i =jsonObjectRequest.toString();
        Log.e("Tag",i);
        requestQueue.add(jsonObjectRequest);
        return "";
    }
}
