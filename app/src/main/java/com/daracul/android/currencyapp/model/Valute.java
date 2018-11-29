package com.daracul.android.currencyapp.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute", strict = false)
public class Valute {
    @Element(name = "Name", required = false)
    private String Name;
    @Element(name = "Value", required = false)
    private String Value;
    @Attribute(name = "ID", required = false)
    private String ID;
    @Element(name = "Nominal", required = false)
    private String Nominal;
    @Element(name = "CharCode", required = false)
    private String CharCode;
    @Element(name = "NumCode", required = false)
    private String NumCode;

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }


    public String getID() {
        return ID;
    }


    public String getNominal() {
        return Nominal;
    }


    public String getCharCode() {
        return CharCode;
    }


    public String getNumCode() {
        return NumCode;
    }


}
