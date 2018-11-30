package com.daracul.android.currencyapp.models;

import com.daracul.android.currencyapp.R;

public class DataUtils {
    public static int getPictureByValuteCode(String valuteCode){
        int pictureId=0;
        switch (valuteCode){
            case "RUB":
                pictureId = R.drawable.ru;
                break;
            case "AUD":
                pictureId = R.drawable.au;
                break;
            case "AZN":
                pictureId = R.drawable.az;
                break;
            case "GBP":
                pictureId = R.drawable.gb;
                break;
            case "AMD":
                pictureId = R.drawable.am;
                break;
            case "BYN":
                pictureId = R.drawable.by;
                break;
            case "BGN":
                pictureId = R.drawable.bg;
                break;
            case "BRL":
                pictureId = R.drawable.br;
                break;
            case "HUF":
                pictureId = R.drawable.hu;
                break;
            case "HKD":
                pictureId = R.drawable.hk;
                break;
            case "DKK":
                pictureId = R.drawable.dk;
                break;
            case "USD":
                pictureId = R.drawable.us;
                break;
            case "EUR":
                pictureId = R.drawable.eu;
                break;
            case "INR":
                pictureId = R.drawable.in;
                break;
            case "KZT":
                pictureId = R.drawable.kz;
                break;
            case "CAD":
                pictureId = R.drawable.ca;
                break;
            case "KGS":
                pictureId = R.drawable.kg;
                break;
            case "CNY":
                pictureId = R.drawable.cn;
                break;
            case "MDL":
                pictureId = R.drawable.md;
                break;
            case "NOK":
                pictureId = R.drawable.no;
                break;
            case "PLN":
                pictureId = R.drawable.pl;
                break;
            case "RON":
                pictureId = R.drawable.ro;
                break;
            case "XDR":
                pictureId = R.drawable.sdr;
                break;
            case "SGD":
                pictureId = R.drawable.sg;
                break;
            case "TJS":
                pictureId = R.drawable.tj;
                break;
            case "TRY":
                pictureId = R.drawable.tr;
                break;
            case "TMT":
                pictureId = R.drawable.tm;
                break;
            case "UZS":
                pictureId = R.drawable.uz;
                break;
            case "UAH":
                pictureId = R.drawable.ua;
                break;
            case "CZK":
                pictureId = R.drawable.cz;
                break;
            case "SEK":
                pictureId = R.drawable.se;
                break;
            case "CHF":
                pictureId = R.drawable.ch;
                break;
            case "ZAR":
                pictureId = R.drawable.za;
                break;
            case "KRW":
                pictureId = R.drawable.kr;
                break;
            case "JPY":
                pictureId = R.drawable.jp;
                break;

        }
        return pictureId;
    }

    public static float convertValueToFloat (String floatString){
        return Float.parseFloat(floatString.replace(',','.'));
    }
}
