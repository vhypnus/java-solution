package org.monan.cache.subject;

import java.util.List;

public abstract class Event implements Runnable {

    private List<Observe> observes ;

    protected Object key ;

    protected Long happenMill ;
}
