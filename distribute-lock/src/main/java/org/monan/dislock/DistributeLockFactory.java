package org.monan.dislock;

public class DistributeLockFactory {

    private static DistributeLockFactory factory = new DistributeLockFactory() ;

    public static DistributeLockFactory getInstance(){
        return factory ;
    }
}
