package org.jms;

import org.apache.commons.collections.list.GrowthList;

public class Saginawj {
    private final String name;

    public Saginawj(String name) {
        this.name = name;
        new GrowthList();
    }

    public String getName() {
        return name;
    }
}
