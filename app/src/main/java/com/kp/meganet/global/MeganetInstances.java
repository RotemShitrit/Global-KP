package com.kp.meganet.global;

/**
 * Created by alex on 11/22/2015.
 */
public class MeganetInstances {
    // this is a singletone that just one instance all the time
    private static MeganetInstances ourInstance = new MeganetInstances();
    public static MeganetInstances getInstance() {
        return ourInstance;
    }

    MeganetEngine _meganetEngine;
    MeganetDB _meganetDb;

    private MeganetInstances() {

    }

    // setters
    public void SetMeganetEngine(MeganetEngine engine_prm)
    {
        _meganetEngine = engine_prm;
    }
    public void SetMeganetDb(MeganetDB db_prm)
    {
        _meganetDb = db_prm;
    }

    // getters
    public MeganetEngine GetMeganetEngine()
    {
        return _meganetEngine;
    }
    public MeganetDB GetMeganetDb()
    {
        return _meganetDb;
    }
}
