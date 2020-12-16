//package com.oms.bean;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class TotalCostBlackBoxTest {
//    Order order;
//
//    @Before
//    public void setUp() throws Exception {
//        order = new Order();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void getTotalCostWithCantCustomer() {
//        order.getTotalCost("BG");
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHNWithNullOrderLine() {
//        float expected = 0;
//        float actual = order.getTotalCost("Hai Bà Trưng, HN");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHN() {
//        ArrayList orderLines = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine("1", "Book", 2, 10000);
//        orderLines.add(orderLine);
//        order.setOrderLines(orderLines);
//        float expected = 20000;
//        float actual = order.getTotalCost("Hai Bà Trưng, HN");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHaNoi() {
//        ArrayList orderLines = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine("1", "Book", 2, 10000);
//        orderLines.add(orderLine);
//        order.setOrderLines(orderLines);
//        float expected = 20000;
//        float actual = order.getTotalCost("Hai Bà Trưng,Hà Nội");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHCM() {
//        ArrayList orderLines = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine("1", "Book", 2, 10000);
//        orderLines.add(orderLine);
//        order.setOrderLines(orderLines);
//        float expected = 20000;
//        float actual = order.getTotalCost("Hai Bà Trưng, HCM");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//
//    @Test
//    public void getTotalCostWithCantCustomerHoChiMinh() {
//        ArrayList orderLines = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine("1", "Book", 2, 10000);
//        orderLines.add(orderLine);
//        order.setOrderLines(orderLines);
//        float expected = 20000;
//        float actual = order.getTotalCost("Hai Bà Trưng, Hồ Chí Minh");
//        assertEquals("Lay tong gia sai",expected, actual, 0.00001);
//    }
//}
