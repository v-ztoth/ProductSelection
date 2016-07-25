package com.sky.services;

import com.sky.domain.model.CustomerId;
import com.sky.domain.model.LocationId;
import com.sky.services.exceptions.LocationIdCannotResolveException;

public interface ICustomerLocationService
{
    LocationId getLocationIdForCustomerId(CustomerId customerId) throws LocationIdCannotResolveException;
}
