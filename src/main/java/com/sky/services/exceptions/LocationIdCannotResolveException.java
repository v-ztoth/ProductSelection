package com.sky.services.exceptions;

public class LocationIdCannotResolveException extends Exception
{
    public LocationIdCannotResolveException(String message)
    {
        super(message);
    }

    public LocationIdCannotResolveException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
