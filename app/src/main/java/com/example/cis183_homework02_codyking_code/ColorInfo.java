package com.example.cis183_homework02_codyking_code;

public class ColorInfo {
    public Integer getColorRed()
    {
        return colorRed;
    }

    public void setColorRed(Integer r)
    {
        colorRed = r;
    }

    public Integer getColorBlue()
    {
        return colorBlue;
    }

    public void setColorBlue(Integer b)
    {
        colorBlue = b;
    }

    public Integer getColorGreen()
    {
        return colorGreen;
    }

    public void setColorGreen(Integer g)
    {
        colorGreen = g;
    }

    public String getColorHex()
    {
        return colorHex;
    }

    public void setColorHex(String c)
    {
        colorHex = c;
    }

    //Used to store color info
    private Integer colorRed;
    private Integer colorGreen;
    private Integer colorBlue;
    private String colorHex;
    public void ColorInformation()
    {

    }
    public void ColorInformation(Integer r, Integer g, Integer b, String c)
    {
        colorRed = r;
        colorGreen = g;
        colorBlue = b;
        colorHex = c;
    }
}
