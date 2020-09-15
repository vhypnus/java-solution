package org.monan.dislock;

public class DistributeRedisLock implements DistributeLock {

    public boolean getLock(String key, Long expireTime) {
        return false;
    }
}
