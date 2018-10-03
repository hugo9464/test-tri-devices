import java.util.Arrays;
import java.util.Comparator;

public class VersionComparator implements Comparator<Device> {
    @Override
    public int compare(Device o1, Device o2) {
        return compareVersions(o1.getVersion(), o2.getVersion());
    }

    private int compareVersions(String x, String y) {
        String[] splittedX = x.split("\\.");
        String[] splittedY = y.split("\\.");

        int xFirstDigit = Integer.parseInt(splittedX[0]);
        int yFirstDigit = Integer.parseInt(splittedY[0]);

        int comparisonResult = Integer.compare(xFirstDigit, yFirstDigit);
        if( comparisonResult != 0) {
            return comparisonResult;
        } else {
            if(splittedX.length > 1 && splittedY.length > 1) {
                return compareVersions(
                        String.join(".", Arrays.copyOfRange(splittedX, 1, splittedX.length)),
                        String.join(".", Arrays.copyOfRange(splittedY, 1, splittedY.length)));
            } else {
                return Integer.compare(splittedX.length, splittedY.length);
            }
        }
    }
}
