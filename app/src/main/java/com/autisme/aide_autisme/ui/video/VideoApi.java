package com.autisme.aide_autisme.ui.video;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.autisme.aide_autisme.R;
import com.autisme.aide_autisme.TraitementHttp;
import com.autisme.aide_autisme.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class VideoApi extends AsyncTask<String,String,String> {
    private String url;
    private VideoFragment fragment;
    private ProgressDialog progressDialog;
    private Context context;

    public VideoApi(String url, VideoFragment fragment){
        this.url = url;
        this.fragment = fragment;
        this.context = fragment.getContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = Utils.progressConfig(progressDialog,context);
        this.progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        TraitementHttp traitementHttp = new TraitementHttp(this.url);
        return traitementHttp.execute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        LinearLayout text = fragment.getActivity().findViewById(R.id.Lvideo);
        traitmentPost(text,s);
        this.progressDialog.hide();
    }

    private void traitmentPost(LinearLayout text,String json) {
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Urlv>>() {
            }.getType();
            List<Urlv> urlvs = gson.fromJson(json, listType);
            for (Urlv urlv : urlvs) {
                Button tableRow = Utils.getTableRow(context,urlv.getTitre(),urlv.getUrl());
                text.addView(tableRow);
            }
        }catch (Exception e){
            Utils.getPostError(text,context);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoFragment getFragment() {
        return fragment;
    }

    public void setFragment(VideoFragment fragment) {
        this.fragment = fragment;
    }
}
