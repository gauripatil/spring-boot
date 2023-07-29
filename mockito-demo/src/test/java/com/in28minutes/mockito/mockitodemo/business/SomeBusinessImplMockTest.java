package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findGreatestFromAllData_basic() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
        assertEquals(25, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_oneValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});
        assertEquals(35, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_emptyArray() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findGreatestFromAllData());
    }

}
