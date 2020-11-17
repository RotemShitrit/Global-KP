package com.kp.meganet.global;

/**
 * Created by alex on 11/22/2015.
 */
public class CommonSettingsData {


    private int _id;
    private String _keyName;
    private String _keyValue;

    // Default constructor
    public CommonSettingsData(){
        _id = -1;
        _keyName = "";
        _keyValue = "";
    }

    // Parameterized constructor
    CommonSettingsData(int id_prm, String keyName_prm, String keyValue_prm) {
        _id = id_prm;
        _keyName = keyName_prm;
        _keyValue = keyValue_prm;
    }

    CommonSettingsData(String keyName_prm, String keyValue_prm)
    {
        _keyName = keyName_prm;
        _keyValue = keyValue_prm;
    }

    // setters
    public void SetID(int value)
    {
        _id = value;
    }
    public void SetKeyName(String value)
    {
        _keyName = value;
    }
    public void SetKeyValue(String value)
    {
        _keyValue = value;
    }

    // getters
    public int GetID()
    {
        return _id;
    }
    public String GetKeyName()
    {
        return _keyName;
    }
    public String GetKeyValue()
    {
        return _keyValue;
    }
}
