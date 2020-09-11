package org.monan.cache;

import com.google.common.cache.Cache;

import java.util.SortedMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CacheWrapper {

    private Cache cache  ;

    // 单线程运行，可以不考虑v
    private volatile AtomicInteger count ;


    //
    private ConcurrentSkipListMap<String,Object> lastTimeMap;

    private CacheWrapperConfig localCacheConfig ;

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024)) ;

    public void put(String key,Object value) {
        long visitTimeMill = System.currentTimeMillis() ;
        if (cache.getIfPresent(key) == null){
            cache.put(key,value);
        }




    }
}
