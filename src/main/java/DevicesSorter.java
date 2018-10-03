
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class DevicesSorter {

    /**
     * Permet de trier une liste de devices par rapport à leur version
     *
     * @param devices la liste de device à trier
     * @return la liste de devices triée
     */
    public static List<Device> sortByVersion(List<Device> devices) {
        Collections.sort(devices,(Comparator)new VersionComparator());
        return devices;
    }
}
