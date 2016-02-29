package com.carpenter.analog_input;

import com.carpenter.analog_input.jna.AIOUSB;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.NativeLongByReference;

public class USBAI1216 {
    public static final int ERROR = -1;

    public long getDeviceId(int deviceIndex) {
        NativeLongByReference deviceId = new NativeLongByReference();
        if (AIOUSB.INSTANCE.QueryDeviceInfo(new NativeLong(deviceIndex), deviceId, null, null, null, null).longValue() == 0) {
            return deviceId.getValue().longValue();
        }
        return ERROR;
    }

    public int getDeviceIndexViaSearch(long deviceId) {
        for (int index = 0; index < 32; ++index) {
            long deviceIdAtIndex = getDeviceId(index);
            if (deviceIdAtIndex == ERROR) {
                break;
            }
            if (deviceIdAtIndex == deviceId) {
                return index;
            }
        }
        return ERROR;
    }
}
