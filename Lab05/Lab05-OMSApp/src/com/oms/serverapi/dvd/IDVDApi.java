package com.oms.serverapi.dvd;

import com.oms.bean.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Map;

public interface IDVDApi {
    ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams);
}
