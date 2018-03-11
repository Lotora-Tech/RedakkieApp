package com.tech.lotora.redkkie;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;

/**
 * Created by stijn on 11/03/2018.
 */

class MyJavaScriptInterface {
    private Context ctx;

    MyJavaScriptInterface(Context ctx) {
        this.ctx = ctx;
    }

    @JavascriptInterface
    public void showHTML(String html) {
        new AlertDialog.Builder(ctx).setTitle("HTML").setMessage(html)
                .setPositiveButton(android.R.string.ok, null).setCancelable(false).create().show();
    }
}
