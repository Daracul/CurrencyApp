package com.daracul.android.currencyapp.models;

public class ValuteItem {
    private float value;
    private int nominal;
    private String valuteCode;
    private String name;
    private int flagPicture;

    public ValuteItem(float value, int nominal, String valuteCode, String name) {
        this.value = value;
        this.nominal = nominal;
        this.valuteCode = valuteCode;
        this.name = name;
        this.flagPicture = DataUtils.getPictureByValuteCode(valuteCode);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getValuteCode() {
        return valuteCode;
    }

    public void setValuteCode(String valuteCode) {
        this.valuteCode = valuteCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagPicture() {
        return flagPicture;
    }

    public void setFlagPicture(int flagPicture) {
        this.flagPicture = flagPicture;
    }
}