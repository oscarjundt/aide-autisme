package com.autisme.aide_autisme;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.autisme.aide_autisme.ui.info.Urlf;

public class Utils {
    public static final String  ERROR_CLIENT_MESSAGE = "Donnée non récupérer";
    public static final String NOT_FOUND_MESSAGE = "Aucune donnée trouver";
    public static final String IN_PROGRESS_MESSAGE  ="En cours";
    @SuppressLint("SetTextI18n")
    public static void getPostError(LinearLayout text, Context context){
        TextView label = new TextView(context);
        label.setText(ERROR_CLIENT_MESSAGE);
        text.addView(label);
    }

    public static void getNotFound(LinearLayout text,Context context){
        TextView label = new TextView(context);
        label.setText(NOT_FOUND_MESSAGE);
        text.addView(label);
    }

    public static @NonNull Button getTableRow(Context context,String title,String url) {
        Button button = new Button(context);
        button.setText(title);
        button.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            v.getContext().startActivity(browserIntent);
        });
        return button;
    }

    public static ProgressDialog progressConfig(ProgressDialog progressDialog,Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(IN_PROGRESS_MESSAGE);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
