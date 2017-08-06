package com.example.den_k.tinkov.utils;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utils {

    private static final SimpleDateFormat DATE_FORMAT
            = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String aHtml) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                ? Html.fromHtml(aHtml, Html.FROM_HTML_MODE_LEGACY)
                : Html.fromHtml(aHtml);
    }

    public static String getTimeString(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return DATE_FORMAT.format(calendar.getTime());
    }

    public static void showSnack(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    private Utils() {
    }

}
