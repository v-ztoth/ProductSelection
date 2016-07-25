package com.sky.view.model;

import java.util.List;

public class ProductSelectorForm
{
    private List<Integer> selectedSportChannelIds;
    private List<Integer> selectedNewsChannelIds;

    public List<Integer> getSelectedSportChannelIds()
    {
        return selectedSportChannelIds;
    }

    public void setSelectedSportChannelIds(List<Integer> selectedSportChannelIds)
    {
        this.selectedSportChannelIds = selectedSportChannelIds;
    }

    public List<Integer> getSelectedNewsChannelIds()
    {
        return selectedNewsChannelIds;
    }

    public void setSelectedNewsChannelIds(List<Integer> selectedNewsChannelIds)
    {
        this.selectedNewsChannelIds = selectedNewsChannelIds;
    }
}
