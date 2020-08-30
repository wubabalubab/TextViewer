package com.example.bean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.textviewer.R;

import java.util.List;

public class TranslationYdActivity  {

    // URLhttp://fanyi.youdao.com/translate
// URL实例http://fanyi.youdao.com/translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=
// 参数说明
// doctype：json 或 xml
// jsonversion：如果 doctype 值是 xml，则去除该值，若 doctype 值是 json，该值为空即可
// xmlVersion：如果 doctype 值是 json，则去除该值，若 doctype 值是 xml，该值为空即可
// type：语言自动检测时为 null，为 null 时可为空。英译中为 EN2ZH_CN，中译英为 ZH_CN2EN，日译中为 JA2ZH_CN，中译日为 ZH_CN2JA，韩译中为 KR2ZH_CN，中译韩为 ZH_CN2KR，中译法为 ZH_CN2FR，法译中为 FR2ZH_CN
// keyform：mdict. + 版本号 + .手机平台。可为空
// model：手机型号。可为空
// mid：平台版本。可为空
// imei：???。可为空
// vendor：应用下载平台。可为空
// screen：屏幕宽高。可为空
// ssid：用户名。可为空
// abtest：???。可为空

    // 请求方式说明
// 请求方式：POST
// 请求体：i
// 请求格式：x-www-form-urlencoded
 private String type;
 private int errorCode;
 private int elapsedTime;
 private List<List<TranslationResultBean>> translateResult;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getElapsedTime() {
        return elapsedTime;
    }
    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
    public List<List<TranslationResultBean>> getTranslateResult() {
        return translateResult;
    }
    public void setTranslateResult(List<List<TranslationResultBean>> translateResult) {
        this.translateResult = translateResult;
    }

    public static class TranslationResultBean {
        private String src;
        private String tgt;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTgt() {
            return tgt;
        }

        public void setTgt(String tgt) {
            this.tgt = tgt;
        }
    }
}
