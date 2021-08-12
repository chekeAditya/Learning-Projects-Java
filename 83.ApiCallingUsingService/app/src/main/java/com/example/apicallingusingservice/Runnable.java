package com.example.apicallingusingservice;

import android.widget.Toast;

import com.example.apicallingusingservice.Service.GetDataService;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface Runnable extends java.lang.Runnable {

    GetDataService getDataService = null;

    java.lang.Runnable runnable = new java.lang.Runnable() {
        @Override
        public void run() {

        }
    };

}
