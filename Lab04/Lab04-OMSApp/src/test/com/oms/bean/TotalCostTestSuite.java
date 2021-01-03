package com.oms.bean;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({com.oms.bean.TotalCostBlackBoxTest.class, TotalCostWhiteBoxTest.class})
public class TotalCostTestSuite {
}
