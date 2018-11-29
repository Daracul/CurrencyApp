package com.daracul.android.currencyapp.model;

import org.simpleframework.xml.Root;

@Root(strict = false)
public class MyResponse {
    private ValCurs ValCurs;

    public ValCurs getValCurs() {
        return ValCurs;
    }

}
