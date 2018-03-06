package com.railscon.netstatusmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.railscon.netstatusmonitor.retrofit.RetrofitClient;
import com.railscon.netstatusmonitor.retrofit.model.Lesson;
import com.railscon.netstatusmonitor.retrofit.model.Version;
import com.railscon.netstatusmonitor.retrofit.services.SoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static final String BASE_URL = "http://www.liujie.org.cn/webservice/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button runCodeBtn = findViewById(R.id.runCode);
        Button clearScreenBtn = findViewById(R.id.clearScreen);
        Button statusBtn = findViewById(R.id.statusBtn);

        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVersionToString(v);

            }
        });

        runCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLesson(v);

            }
        });

        clearScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
            }
        });
    }

    public void getLesson(View v) {

        Retrofit retrofit = RetrofitClient.getClient();

        SoService service = retrofit.create(SoService.class);

        Call<Lesson[]> call = service.getLessons();

        call.enqueue(new Callback<Lesson[]>() {
                         @Override
                         public void onResponse(Call<Lesson[]> call, Response<Lesson[]> response) {

                             StringBuilder res = new StringBuilder();
                             if (response.body() != null) {
                                 for (Lesson lesson : response.body()) {
                                     res.append(lesson.getCTitle()).append("\n");
                                 }
                                 textView.setText(res.toString());
                             } else {
                                 textView.setText("none");
                             }


                         }

                         @Override
                         public void onFailure(Call<Lesson[]> call, Throwable t) {

                         }
                     }
        );


    }

    public void getVersionToString(View v) {

        Retrofit retrofit = RetrofitClient.getClient();
        SoService service = retrofit.create(SoService.class);
        Call<Version> call = service.getVersion();
        call.enqueue(new Callback<Version>() {
                         @Override
                         public void onResponse(Call<Version> call, Response<Version> response) {

                             String res = null;
                             if (response.body() != null) {
                                 res = Integer.toString(response.body().getVersion());
                             }
                             textView.setText(res);
                         }

                         @Override
                         public void onFailure(Call<Version> call, Throwable t) {
                         }
                     }
        );

    }
}
