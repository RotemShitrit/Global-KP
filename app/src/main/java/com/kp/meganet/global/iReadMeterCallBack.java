package com.kp.meganet.global;

/**
 * Created by alex on 11/22/2015.
 */
public interface iReadMeterCallBack {
    public abstract void OnReadMeters(byte[] data_prm);
    public abstract void OnFilterSet(boolean status);
}
