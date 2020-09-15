package org.monan.dislock;

public class DistributeZkLock implements DistributeLock {

    public boolean getLock(String key, Long expireTime) {
        return false;
    }
}
