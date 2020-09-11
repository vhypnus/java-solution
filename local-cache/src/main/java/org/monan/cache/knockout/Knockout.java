package org.monan.cache.knockout;

import org.monan.cache.subject.Event;
import org.monan.cache.subject.Observe;

import java.util.List;

public class Knockout implements Observe {

    private List<KnockoutStrategy> knockoutStrategies ;

    @Override
    public void observe(Event event) {

    }
}
