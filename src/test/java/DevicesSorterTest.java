import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DevicesSorterTest {

    @Test
    public void should_sort_devices_by_version() {

        //given
        Device device1 = newDevice("2");
        Device device2 = newDevice("3.0");
        Device device3 = newDevice("2.0.3");
        Device device4 = newDevice("2.0.1.3");
        Device device5 = newDevice("2.0.1");

        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        devices.add(device3);
        devices.add(device4);
        devices.add(device5);

        //when
        final List<Device> sortedDevices = DevicesSorter.sortByVersion(devices);

        //then
        assertNotNull(sortedDevices);

        List<Device> expectedDevices = new ArrayList<>();
        expectedDevices.add(device1);
        expectedDevices.add(device5);
        expectedDevices.add(device4);
        expectedDevices.add(device3);
        expectedDevices.add(device2);

        assertEquals(expectedDevices, sortedDevices);

    }

    @Test
    public void should_sort_devices_by_version_with_same_common_digit() {

        //given
        Device device1 = newDevice("2.3.4");
        Device device2 = newDevice("2.3");

        List<Device> devices = new ArrayList<>();
        devices.add(device2);
        devices.add(device1);

        //when
        final List<Device> sortedDevices = DevicesSorter.sortByVersion(devices);

        //then
        assertNotNull(sortedDevices);

        List<Device> expectedDevices = new ArrayList<>();
        expectedDevices.add(device2);
        expectedDevices.add(device1);

        assertEquals(expectedDevices, sortedDevices);

    }

    @Test
    public void should_sort_devices_by_version_with_equal_versions() {

        //given
        Device device1 = newDevice("2.3");
        Device device2 = newDevice("2.3");

        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);

        //when
        final List<Device> sortedDevices = DevicesSorter.sortByVersion(devices);

        //then
        assertNotNull(sortedDevices);

        List<Device> expectedDevices = new ArrayList<>();
        expectedDevices.add(device1);
        expectedDevices.add(device2);

        assertEquals(expectedDevices, sortedDevices);

    }

    @Test
    public void should_sort_devices_by_version_with_1_digit() {

        //given
        Device device1 = newDevice("2.3");
        Device device2 = newDevice("2");

        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);

        //when
        final List<Device> sortedDevices = DevicesSorter.sortByVersion(devices);

        //then
        assertNotNull(sortedDevices);

        List<Device> expectedDevices = new ArrayList<>();
        expectedDevices.add(device2);
        expectedDevices.add(device1);

        assertEquals(expectedDevices, sortedDevices);

    }

    private Device newDevice(String version) {
        Device device = new Device();
        device.setName("device name");
        device.setVersion(version);
        return device;
    }
}