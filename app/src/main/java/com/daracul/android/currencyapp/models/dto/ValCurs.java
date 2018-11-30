package com.daracul.android.currencyapp.models.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs", strict = false)
public class ValCurs {
    @ElementList(inline = true, required = false)
    private List<Valute> valuteList;

    @Attribute(name = "Date", required = false)
    private String date;
    @Attribute(name = "name" , required = false)
    private String name;


    public List<Valute> getValuteList() {
        return valuteList;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
