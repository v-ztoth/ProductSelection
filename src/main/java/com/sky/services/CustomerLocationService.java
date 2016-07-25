package com.sky.services;

import com.sky.domain.model.CustomerId;
import com.sky.domain.model.LocationId;
import com.sky.services.exceptions.LocationIdCannotResolveException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerLocationService implements ICustomerLocationService
{
    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public LocationId getLocationIdForCustomerId(CustomerId customerId) throws LocationIdCannotResolveException
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((MAX - MIN) + 1) + MIN;

        if (randomNum > 80)
        {
            throw new LocationIdCannotResolveException("Cannot resolve location id");
        }

        if (randomNum % 2 == 0)
        {
            return LocationId.valueOf("LONDON");
        }
        else
        {
            return LocationId.valueOf("LIVERPOOL");
        }
    }
}
