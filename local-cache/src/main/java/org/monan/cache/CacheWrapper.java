package org.monan.cache;

import com.google.common.cache.Cache;

import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class CacheWrapper {

    private Cache cache  ;


    //
    private ConcurrentSkipListMap<String,Object> lastTimeMap;

    private CacheWrapperConfig localCacheConfig ;



    public void put(String key,Object value) {
        cache.put(key,value);

    }
}
