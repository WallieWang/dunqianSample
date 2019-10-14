package com.example.dunqian.manager;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RequestManager {

    private static RequestManager manager;
    private RequestQueue queue;

    public static RequestManager getInstance(){
        if(manager==null){
            manager = new RequestManager();
        }
        return  manager;
    }

    public void init(Context context){
        queue = Volley.newRequestQueue(context);
    }

    public void sample(String token, String qrCodeContent, RequestListener listener){
        String url = "https://store.mastripms.com/api/app_exam";
        HashMap<String, String> header = new HashMap<>();
        header.put("Accept", "application/json");
        HashMap<String, String> body = new HashMap<>();
        body.put("device_token", token);
        body.put("qrcode", qrCodeContent);
        volleyRequest(Request.Method.POST, url, header, body, listener);
    }

    private void volleyRequest(int method, String url, final Map<String, String> header, final Map<String, String> body, final RequestListener listener){
        StringRequest request = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders(){
                if(header==null){
                    return  new HashMap<>();
                }
                return header;
            }
            @Override
            protected Map<String, String> getParams()  {
                if(body==null){
                    return  new HashMap<>();
                }
                return body;
            }
        };
        queue.add(request);
    }

    public interface RequestListener {
        void onSuccess(String response);
        void onError(VolleyError error);
    }

}
