package com.oms.serverapi.cd;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;

import java.util.ArrayList;
import java.util.Map;

public interface ICDApi {
    ArrayList<CompactDisc> getCds(Map<String, String> queryParams);
    CompactDisc updateCD(CompactDisc cd);
}
