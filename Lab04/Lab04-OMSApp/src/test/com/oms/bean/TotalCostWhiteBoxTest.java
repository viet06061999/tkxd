//package com.oms.bean;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class TotalCostWhiteBoxTest {
//    Order order;
//
//    @Before
//    public void setUp() throws Exception {
//        order = new Order();
//        ArrayList orderLines = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine("1", "Book", 2, 10000);
//        orderLines.add(orderLine);
//        order.setOrderLines(orderLines);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void getTotalCostWithCantCustomer() {
//        order.getTotalCost("Tân Yên, Bắc Giang");
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHN() {
//        float expected = 20000;
//        float actual = order.getTotalCost("Hai Bà Trưng, HN");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//}
