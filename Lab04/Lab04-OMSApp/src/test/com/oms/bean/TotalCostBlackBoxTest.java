package com.oms.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TotalCostBlackBoxTest {
    Order  order = new Order();
    Double expected = 0.0;

    public TotalCostBlackBoxTest(String address, ArrayList<OrderLine> orderLines, Double expected) throws Exception {
        super();
        System.out.println(address);
        System.out.println(orderLines);
        System.out.println(expected);
        order.setCustomerAddress(address);
        order.setOrderLines(orderLines);
        this.expected = expected;
        order.setOrderLines(orderLines);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "Hai Bà Trưng, Hà Nội",setWeight(2), 122000.0},
                {  "Hoàng Mai, HN",setWeight(2), 122000.0},
                {  "Nguyễn Chí Thanh, HCM",setWeight(4), 127000.0},
                {  "Quận 2, Thành phố Hồ Chí Minh",setWeight(4), 127000.0},
                {  "Tân yên, Bắc Giang",setWeight(4.5f), 150000.0},
                { "Tân yên, Bắc Giang",setWeight(0.5f), 130000.0 }
        });
    }


    @Test
    public void getTotalCost() {
        assertEquals("Lay tong gia sai",expected, order.getTotalCost(), 0.00001);
    }

    private static ArrayList<OrderLine>  setWeight(float weight){
        ArrayList orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine("1", "Book", 1, 100000, weight);
        orderLines.add(orderLine);
        return  orderLines;
    }
}
