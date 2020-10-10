package com.nischitha.albumlist.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.nischitha.albumlist.MyApplication;
import com.nischitha.albumlist.R;
import com.nischitha.albumlist.di.component.ApplicationComponent;
import com.nischitha.albumlist.di.component.DaggerMainActivityComponent;
import com.nischitha.albumlist.di.component.MainActivityComponent;
import com.nischitha.albumlist.di.module.MainActivityContextModule;
import com.nischitha.albumlist.di.qualifier.ActivityContext;
import com.nischitha.albumlist.di.qualifier.ApplicationContext;
import com.nischitha.albumlist.pojo.Albumn;
import com.nischitha.albumlist.pojo.Result;
import com.nischitha.albumlist.retrofit.APIInterface;
import com.nischitha.albumlist.adapter.RecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private ProgressBar spinner;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albumn);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.progressBar1);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        spinner.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                recyclerViewAdapter.clear();
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                apiInterface.getAlbums(editText.getText().toString()).enqueue(new Callback<Albumn>() {
                    @Override
                    public void onResponse(Call<Albumn> call, Response<Albumn> response) {
                        spinner.setVisibility(View.GONE);
                        if(response.body().results.size() != 0) {
                            recyclerView.setVisibility(View.VISIBLE);
                            populateRecyclerView(response.body().results);
                        }
                    }

                    @Override
                    public void onFailure(Call<Albumn> call, Throwable t) {
                        spinner.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    private void populateRecyclerView(List<Result> response) {
       recyclerViewAdapter.setData(response);
    }
}
