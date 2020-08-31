package com.example.textviewer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basic.Translation;
import com.example.bean.TranslationYdActivity;
import com.example.minterface.GetRequest_Interface;
import com.example.minterface.MineInterfaceYd;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslationActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.textView2)
    TextView textView2;
    private String result;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        ButterKnife.bind(this);
        request();

    }

    private void requestYd(String input) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MineInterfaceYd interfaceYd = retrofit.create(MineInterfaceYd.class);
        Call<TranslationYdActivity> call = interfaceYd.getCall(input);
        call.enqueue(new Callback<TranslationYdActivity>() {
            @Override
            public void onResponse(Call<TranslationYdActivity> call, Response<TranslationYdActivity> response) {
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
                result = String.valueOf(response.body().getTranslateResult().get(0).get(0).getTgt());
                textView2.setText(result);
            }

            @Override
            public void onFailure(Call<TranslationYdActivity> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    private void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        Call<Translation> call = request_interface.getCall();
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Toast.makeText(TranslationActivity.this, "connect fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.button2)
    public void onViewClicked() {

        input= String.valueOf(editText.getText());
        requestYd(input);

        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView2.getResources().getColor(R.color.colorAccent);

                    }
                });
            }
        }).start();

    }
}
