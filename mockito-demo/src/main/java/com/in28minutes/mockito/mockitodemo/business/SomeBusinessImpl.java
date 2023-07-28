package com.in28minutes.mockito.mockitodemo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int number:
             data) {
            if(number > greatestValue) {
                greatestValue = number;
            }
        }
        return greatestValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}