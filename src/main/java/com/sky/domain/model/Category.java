package com.sky.domain.model;

public class Category
{
    private String value;

    public static Category valueOf(String value)
    {
        return new Category(value);
    }

    private Category(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
