package org.monan.dislock;

public interface DistributeLock {

    public boolean getLock(String key,Long expireTime) ;
}
