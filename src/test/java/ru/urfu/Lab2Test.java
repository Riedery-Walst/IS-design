package ru.urfu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Lab2Test {

    @Test
    public void testGetDivSum() {
        Lab2 lab2 = new Lab2();
        double result = lab2.getDivSum(6, 5);
        assertEquals(2.283, result, 0.01, "Ошибка в вычислении суммы дробей");
    }

    @Test
    public void testGetSum() {
        Lab2 lab2 = new Lab2();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sum = lab2.getSum(list);
        assertEquals(15, sum, "Ошибка в суммировании элементов списка");
    }

    @Test
    public void testGetSumWithI() {
        Lab2 lab2 = new Lab2();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sumWithI = lab2.getSumWithI(list);
        assertEquals(55, sumWithI, "Ошибка в суммировании элементов с индексами");
    }

    @Test
    public void testRun() {
        Lab2 lab2 = new Lab2();
        assertDoesNotThrow(() -> lab2.run(), "Ошибка выполнения метода run");
    }
}