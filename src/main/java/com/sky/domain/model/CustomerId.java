package com.sky.domain.model;

public class CustomerId
{
    private String value;

    public static CustomerId valueOf(String value)
    {
        return new CustomerId(value);
    }

    private CustomerId(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
