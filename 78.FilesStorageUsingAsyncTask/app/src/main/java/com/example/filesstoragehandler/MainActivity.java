package com.example.filesstoragehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_STRING_KEY = "PREF_STRING_KEY";
    private EditText mEtName;
    private Button mBtnSave;
    private Button mBtnGet;
    private TextView mTvDisplayText;
    private ProgressDialog progressDialog;
    private EditText field1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Aditya", "onCreate");
        initViews();
    }

    private void initViews() {
        mEtName = findViewById(R.id.etName);
        mBtnSave = findViewById(R.id.btnSave);
        mBtnGet = findViewById(R.id.btnGetData);
        mTvDisplayText = findViewById(R.id.tvTextView);
        asyncTask.execute();
    }

    private AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            mBtnSave.setOnClickListener(v -> {
                PreferenceHelper.writeStringToPreference(MainActivity.this, PREF_STRING_KEY, mEtName.getText().toString());
                Log.d("Aditya", "Saved");
            });
            progressDialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            mBtnGet.setOnClickListener(v -> {
                progressDialog.show();
                String stringFromPref = PreferenceHelper.getStringFromPreference(MainActivity.this, PREF_STRING_KEY);
                mTvDisplayText.setText(stringFromPref);
                Log.d("Aditya", "Get Data");
                progressDialog.dismiss();
            });
        }
    };

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("Aditya", "onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("Aditya", "onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("Aditya", "onPause");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("Aditya", "onRestart");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("Aditya", "onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("Aditya", "onDestroy");
//    }

    /**
     * text saved while I enter in the Editext
     */


//    field1.addTextChangedListener(new TextWatcher() {
//
//        @Override
//        public void afterTextChanged(Editable s) {}
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start,
//        int count, int after) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start,
//        int before, int count) {
//            // check here
//        }
//    });
}
/*
mBtnSave.setOnClickListener(v -> {
                PreferenceHelper.writeStringToPreference(MainActivity.this, PREF_STRING_KEY, mEtName.getText().toString());
                Log.d("Aditya", "Saved");
            });

progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading");
            progressDialog.show();

mBtnGet.setOnClickListener(v -> {
                String stringFromPref = PreferenceHelper.getStringFromPreference(MainActivity.this, PREF_STRING_KEY);
                mTvDisplayText.setText(stringFromPref);
                Log.d("Aditya", "Get Data");
            });
 */