package com.sky.domain.model;


public class LocationId
{
    private String value;

    public static LocationId valueOf(String value)
    {
        return new LocationId(value);
    }

    private LocationId(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
