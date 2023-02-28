package allForDragons;

import java.util.Comparator;

public class AgeComparator implements Comparator<Dragon> {

    @Override
    public int compare(Dragon dragon1, Dragon dragon2) {
        int result = 0;
        if (dragon1.getAge() < dragon2.getAge()) {
            result = -1;
        }
        if (dragon1.getAge() > dragon2.getAge()) {
            result = 1;
        }
        return result;
    }
}
