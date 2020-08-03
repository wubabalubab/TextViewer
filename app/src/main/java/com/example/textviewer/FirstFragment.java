package com.example.textviewer;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.PrimitiveIterator;

public class FirstFragment extends Fragment {
    String url="http://oa.zhenghongwy.com:8080/zhwy/ydh.html?door=02,03,05,06,07,08,10,11,12,13&id=LYxA/L8vCtbrMKNdvPtUqQ==&from=singlemessage";
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        WebView fistfargmentweb=getActivity().findViewById(R.id.firstfrag_webView);
        WebSettings settings = fistfargmentweb.getSettings();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        Toast.makeText(getContext(), "xxx", Toast.LENGTH_SHORT).show();
        settings.setBlockNetworkImage(false);
        settings.setJavaScriptEnabled(true);
        fistfargmentweb.setWebViewClient(new WebViewClient());
        fistfargmentweb.loadUrl(url);



    }
}
