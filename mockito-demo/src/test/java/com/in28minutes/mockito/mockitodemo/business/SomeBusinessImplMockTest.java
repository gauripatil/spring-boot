package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplMockTest {

    @Test
    void findGreatestFromAllData_basic() {
        DataService dataService = mock(DataService.class);
//        dataService.retrieveAllData() => new int[]{25, 15, 5};
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        assertEquals(25, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_one_value() {
        DataService dataService = mock(DataService.class);
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        assertEquals(35, businessImpl.findGreatestFromAllData());
    }

}
