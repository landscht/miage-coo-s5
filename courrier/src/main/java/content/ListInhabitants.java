package content;

import city.Inhabitant;

import java.util.List;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a list of inhabitants that can be in a fool letter
 *
 */

public class ListInhabitants implements Content {

    private List<Inhabitant> list;

    public ListInhabitants(List<Inhabitant> list) {
        this.list = list;
    }

    public List<Inhabitant> getList() {
        return this.list;
    }

}
