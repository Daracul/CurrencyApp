package com.daracul.android.currencyapp.models.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute", strict = false)
public class Valute {
    @Element(name = "Name", required = false)
    private String name;
    @Element(name = "Value", required = false)
    private String value;
    @Attribute(name = "ID", required = false)
    private String id;
    @Element(name = "Nominal", required = false)
    private String nominal;
    @Element(name = "CharCode", required = false)
    private String charCode;
    @Element(name = "NumCode", required = false)
    private String numCode;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


    public String getId() {
        return id;
    }


    public String getNominal() {
        return nominal;
    }


    public String getCharCode() {
        return charCode;
    }


    public String getNumCode() {
        return numCode;
    }


}
