import java.util.ArrayList;
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

        List<Device> sortedDevices = new ArrayList<>();

        devices.forEach( device -> sortedDevices.add(findDevicePosition(sortedDevices, device), device));

        return sortedDevices;
    }

    /**
     * Permet de trouver la position d'un device dans la liste triée
     *
     * @param sortedDevices la liste triée
     * @param deviceToAdd le device à insérer
     * @return la position à laquelle insérer le device
     */
    private static int findDevicePosition(List<Device> sortedDevices, Device deviceToAdd){

        // on parcourt la liste de device triée pour comparer chaque device avec celui à insérer
        for(int i=0 ; i<sortedDevices.size() ; i++ ) {

            Device currentDevice = sortedDevices.get(i);
            Device newestDevice = findNewestDevice(currentDevice, deviceToAdd);

            // si le device à insérer est plus ancien que le device testé, alors il le remplace
            if(!deviceToAdd.equals(newestDevice)) {
                return i;
            }
        }

        return sortedDevices.size();
    }

    /**
     * Permet de comparer les versions de deux devices
     *
     * @param device1 le premier device
     * @param device2 le deuxième device
     * @return le device le plus récent (avec la version la plus élevée)
     */
    private static Device findNewestDevice(Device device1, Device device2) {

        String version1[] = device1.getVersion().split("\\.");
        String version2[] = device2.getVersion().split("\\.");

        // récupération de la taille de la plus petite version en nombre de digits
        int shortestVersionSize = version1.length;
        if(version2.length < version1.length) {
            shortestVersionSize = version2.length;
        }

        // on parcourt la plus petite version pour comparer chaque digit
        for (int i = 0 ; i < shortestVersionSize; i++) {
            int digitComparator = compare(Integer.parseInt(version1[i]), Integer.parseInt(version2[i]));

            //si les deux digits sont différents, on renvoie le device le plus récent
            if (digitComparator == -1){
                return device2;
            } else if (digitComparator == 1){
                return device1;
            }
        }

        // si après avoir parcouru la plus courte version on n'a pas de différence,
        // alors on se base sur la taille des versions (la plus longue est la plus élevée)
        // si les deux versions sont égales, alors on renvoie le device2 pour placer le nouveau device à la suite
        if (version1.length == version2.length) {
            return device2;
        } else if (shortestVersionSize == version1.length) {
            return device2;
        } else {
            return device1;
        }
    }
}
