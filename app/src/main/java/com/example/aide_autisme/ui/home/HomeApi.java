package com.example.aide_autisme.ui.home;

import android.os.AsyncTask;

import androidx.fragment.app.Fragment;

public class HomeApi extends AsyncTask<String, String, String> {
    private String urlApi;
    private HomeFragment home;

    public HomeApi(String urlApi,HomeFragment home){
        this.urlApi = urlApi;
        this.home = home;
    }
    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... strings) {
        return "";
    }

    @Override
    protected void onPostExecute(String s) {

    }

    public String getUrlApi() {
        return urlApi;
    }

    public void setUrlApi(String urlApi) {
        this.urlApi = urlApi;
    }

    public HomeFragment getHome() {
        return home;
    }

    public void setHome(HomeFragment home) {
        this.home = home;
    }
}
