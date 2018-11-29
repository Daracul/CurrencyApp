package com.daracul.android.currencyapp.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class ValCurs {
    @ElementList(inline = true)
    private List<Valute> valuteList;

    @Attribute(name = "Date")
    private String Date;
    @Attribute(name = "name")
    private String name;


    public List<Valute> getValuteList() {
        return valuteList;
    }

    public String getDate() {
        return Date;
    }

    public String getName() {
        return name;
    }
}
