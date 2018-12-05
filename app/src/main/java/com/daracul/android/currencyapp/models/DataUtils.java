package com.daracul.android.currencyapp.models;

import com.daracul.android.currencyapp.R;

import java.util.List;

import androidx.annotation.NonNull;

public class DataUtils {
    private static final String RUB_CODE = "RUB";
    private static final String RUB = "Российский рубль";

    public static int getPictureByValuteCode(String valuteCode) {
        int pictureId = 0;
        switch (valuteCode) {
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
            default:
                pictureId = R.drawable.valute;
                break;

        }
        return pictureId;
    }

    public static float convertValueToFloat(String floatString) {
        return Float.parseFloat(floatString.replace(',', '.'));
    }

    public static int findUSAPosition(List<ValuteItem> valuteItems) {
        for (int i = 0; i < valuteItems.size(); i++) {
            if (valuteItems.get(i).getValuteCode().equals("USA")) return i;
        }
        return 0;
    }

    public static ValuteItem createRouble() {
        return new ValuteItem(1.0f, 1, RUB_CODE, makeFirstLetterWithLowerCase(RUB));
    }

    public static String makeFirstLetterWithLowerCase(@NonNull String valuteName) {
        if (!Character.isLowerCase(valuteName.charAt(1))) {
            return valuteName;
        }
        return valuteName.substring(0, 1).toLowerCase() + valuteName.substring(1);
    }

    public static String getPictureUrl(String valuteCode){
        return String.format("https://www.countryflags.io/%s/shiny/64.png",valuteCode.substring(0,2));
    }
}
