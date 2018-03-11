package com.tech.lotora.redkkie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stijn on 11/03/2018.
 */

@SuppressLint("SetTextI18n")
class PageParser {
    static void parsePage(Context context, final WebView mWebView) {
        // ...
        final String[] answer = {""};

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://forum.koornbeurs.nl/?password-protected=login";
        mWebView.loadUrl(url);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        answer[0] = "Response is: " + response.indexOf("loginform");
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                answer[0] = "That didn't work!";
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Query String Parameters", "password-protected=login");
                params.put("Form Data", "password_protected_pwd=redakkiekerst&wp-submit=Inloggen&testcookie=1&password-protected=login&redirect_to=http%3A%2F%2Fforum.koornbeurs.nl%2Findex.php%2F2018%2F03%2F");
                return params;
            }
        };;

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}
