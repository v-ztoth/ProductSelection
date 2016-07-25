
package com.sky.view.controllers;

import com.sky.domain.model.Category;
import com.sky.domain.model.CustomerId;
import com.sky.domain.model.LocationId;
import com.sky.domain.model.Product;
import com.sky.services.ICatalogueService;
import com.sky.services.ICustomerLocationService;
import com.sky.services.exceptions.LocationIdCannotResolveException;
import com.sky.view.model.ProductSelectorForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/selectProduct")
public class ProductSelectionController
{
    private static final Logger LOGGER = Logger.getLogger(ProductSelectionController.class);

    private final ICatalogueService catalogueService;
    private final ICustomerLocationService customerLocationService;

    @Autowired
    public ProductSelectionController(ICatalogueService catalogueService,
                                      ICustomerLocationService customerLocationService)
    {
        this.catalogueService = catalogueService;
        this.customerLocationService = customerLocationService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm(@CookieValue(value = "customerId", defaultValue = "123") String customerId)
            throws LocationIdCannotResolveException {
        ModelAndView model = new ModelAndView();
        ProductSelectorForm productSelectorForm = new ProductSelectorForm();

        LocationId locationId = getLocationIdForCustomeId(CustomerId.valueOf(customerId));

        List<Product> sportChannels = getChannelsByCategory(Category.valueOf("Sports"), locationId);

        List<Product> newsChannels = getChannelsByCategory(Category.valueOf("News"), locationId);

        model.addObject("productSelectorForm", productSelectorForm);
        model.addObject("sportChannels", sportChannels);
        model.addObject("newsChannels", newsChannels);

        model.setViewName("productselection");

        return model;
    }

    private LocationId getLocationIdForCustomeId(CustomerId customerId) throws LocationIdCannotResolveException {
        return customerLocationService.getLocationIdForCustomerId(customerId);
    }

    private List<Product> getChannelsByCategory(Category category, LocationId locationId)
    {
        return catalogueService.getProductsByCategoryAndLocationId(category, locationId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@CookieValue(value = "customerId", defaultValue = "123") String customerId,
                             Model model, ProductSelectorForm form, BindingResult result)
    {
        List<Product> selectedSportsChannels = new ArrayList<>();
        List<Integer> selectedSportChannelIds = form.getSelectedSportChannelIds();
        if (!CollectionUtils.isEmpty(selectedSportChannelIds) )
        {
            selectedSportsChannels = selectedSportChannelIds.stream()
                    .map(id -> getProductById(id))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        List<Product> selectedNewsChannels = new ArrayList<>();
        List<Integer> selectedNewsChannelIds = form.getSelectedNewsChannelIds();
        if (!CollectionUtils.isEmpty(selectedNewsChannelIds) )
        {
            selectedNewsChannels = selectedNewsChannelIds.stream()
                    .map(id -> getProductById(id))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        model.addAttribute("selectedSportChannels", selectedSportsChannels);
        model.addAttribute("selectedNewsChannels", selectedNewsChannels);
        model.addAttribute("customerId", customerId);

        return "confirmation";
    }

    private Product getProductById(Integer id)
    {
        return catalogueService.getProductById(id);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        model.addObject("errMsg", ex);

        LOGGER.error(ex);

        return model;

    }
}
