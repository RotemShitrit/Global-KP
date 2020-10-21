package com.kp.meganet.global;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

/**
 * Created by alex on 11/22/2015.
 */
public class DevDB {
    public DevDB(){parameters = new ArrayList<QryParams>();}

    public DevDB(List<QryParams> parameters_prm)
    {
        parameters = parameters_prm;
    }
    @ElementList
    public List<QryParams> parameters;
}
