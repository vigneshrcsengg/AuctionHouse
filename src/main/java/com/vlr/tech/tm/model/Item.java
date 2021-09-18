package com.vlr.tech.tm.model;

import java.util.Objects;

/**
 *
 * @author Vignesh
 */
public class Item {

    final String id;
    final String name;

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{ id: %s, name: %s }", id, name);
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o == this) {
            equals = true;
        } else if (o instanceof Item) {
            Item item = (Item) o;
            equals = Objects.equals(id, item.id) && Objects.equals(name, item.name);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
