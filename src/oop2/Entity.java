package oop2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Flower on 10/28/2015.
 */
public class Entity {
    int id;
    String name;
    double salary;
    List<String> values = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (id != entity.id) return false;
        if (Double.compare(entity.salary, salary) != 0) return false;
        if (!name.equals(entity.name)) return false;
        return !(values != null ? !values.equals(entity.values) : entity.values != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    @Override
    public Entity clone() {

        Entity entity;
        try {
            entity = (Entity) super.clone();
            entity.values = (List) ((ArrayList)this.values).clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }

        return entity;
    }
}
