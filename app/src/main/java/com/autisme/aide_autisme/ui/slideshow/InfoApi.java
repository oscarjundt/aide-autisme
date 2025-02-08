package com.autisme.aide_autisme.ui.slideshow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.autisme.aide_autisme.R;
import com.autisme.aide_autisme.TraitementHttp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class InfoApi extends AsyncTask<String,String,String> {
    private String url;
    private SlideshowFragment fragment;
    private ProgressDialog progressDialog;

    public InfoApi(String url,SlideshowFragment fragment){
        this.url = url;
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog = new ProgressDialog(this.fragment.getContext());
        this.progressDialog.setMessage("en cours");
        this.progressDialog.setCancelable(false);
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
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Urlf>>(){}.getType();
        List<Urlf> urlfs = gson.fromJson(s, listType);
        LinearLayout text = fragment.getActivity().findViewById(R.id.Llien);
        for(Urlf urlf: urlfs){
            Button tableRow = getTableRow(urlf);
            text.addView(tableRow);
        }
        this.progressDialog.hide();
    }

    private @NonNull Button getTableRow(Urlf urlf) {
        Button button = new Button(this.fragment.getContext());
        button.setText(urlf.getTitre());
        button.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlf.getUrl()));
            v.getContext().startActivity(browserIntent);
        });
        return button;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SlideshowFragment getFragment() {
        return fragment;
    }

    public void setFragment(SlideshowFragment fragment) {
        this.fragment = fragment;
    }
}
