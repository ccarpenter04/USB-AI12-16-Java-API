package com.carpenter.analog_input.jna;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * A JNA mapping for the AIOUSB native library provided by accesio.com
 * Descriptions of the various functions and their proper usage can be found in the provided PDF (which was downloaded from accesio.com)
 *
 * @author Christopher Carpenter, Ivan Gomes
 */
public interface AIOUSB extends StdCallLibrary {
    AIOUSB INSTANCE = (AIOUSB) Native.synchronizedLibrary((AIOUSB) Native.loadLibrary(AIOUSB.class));

    /**
     * unsigned long ADC_SetConfig(unsigned long DeviceIndex, void *pConfigBuf, unsigned long *ConfigBufSize)
     */
    NativeLong ADC_SetConfig(NativeLong DeviceIndex, Pointer pConfigBuf, NativeLongByReference ConfigBufSize);

    /**
     * unsigned long ADC_GetConfig(unsigned long DeviceIndex, void *pConfigBuf, unsigned long *ConfigBufSize)
     */
    NativeLong ADC_GetConfig(NativeLong DeviceIndex, Pointer pConfigBuf, NativeLongByReference ConfigBufSize);

    /**
     * unsigned long ADC_GetScan(unsigned long DeviceIndex, unsigned short *pBuf)
     */
    NativeLong ADC_GetScan(NativeLong DeviceIndex, ShortByReference pBuf);

    /**
     * unsigned long ADC_GetScanV(unsigned long DeviceIndex, double *pBuf);
     */
    NativeLong ADC_GetScanV(NativeLong DeviceIndex, DoubleByReference pBuf);

    /**
     * unsigned long QueryDeviceInfo(unsigned long DeviceIndex, unsigned long *pPID,
     * unsigned long *pNameSize, char *pName,
     * unsigned long *pDIOBytes, unsigned long *pCounters)
     */
    NativeLong QueryDeviceInfo(NativeLong DeviceIndex, NativeLongByReference pPID,
                               NativeLongByReference pNameSize, ByteByReference pName,
                               NativeLongByReference pDIOBytes, NativeLongByReference pCounters);

    /**
     * unsigned long ADC_GetChannelV(unsigned long DeviceIndex, unsigned long ChannelIndex, double *pBuf)
     */
    NativeLong ADC_GetChannelV(NativeLong DeviceIndex, NativeLong ChannelIndex, DoubleByReference pBuf);

    /**
     * unsigned long ADC_BulkAcquire(unsigned long DeviceIndex, unsigned long BufSize, void *pBuf)
     */
    NativeLong ADC_BulkAcquire(NativeLong DeviceIndex, NativeLong BufSize, Pointer pBuf);

    /**
     * unsigned long ADC_BulkPoll(unsigned long DeviceIndex, unsigned long *BytesLeft)
     */
    NativeLong ADC_BulkPoll(NativeLong DeviceIndex, NativeLongByReference BytesLeft);

    /**
     * unsigned long ADC_QueryCal(unsigned long DeviceIndex)
     */
    NativeLong ADC_QueryCal(NativeLong DeviceIndex);

    /**
     * unsigned long ADC_SetCal(unsigned long DeviceIndex, char *CalFileName)
     */
    NativeLong ADC_SetCal(NativeLong DeviceIndex, ByteByReference CalFileName);

    /**
     * unsigned long ADC_SetCalAndSave(unsigned long DeviceIndex, char *CalFileName, char *SaveCalFileName)
     */
    NativeLong ADC_SetCalAndSave(NativeLong DeviceIndex, ByteByReference CalFileName, ByteByReference SaveCalFileName);
}
