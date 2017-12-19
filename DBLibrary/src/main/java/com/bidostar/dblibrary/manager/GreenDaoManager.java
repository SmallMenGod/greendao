package com.bidostar.dblibrary.manager;

import android.content.Context;

import com.bidostar.dblibrary.db.DaoMaster;
import com.bidostar.dblibrary.db.DaoSession;
import com.bidostar.dblibrary.helpter.PinanDBHelper;

/**
 * @author zsh27
 * @date 2017/12/18.
 * description .
 * @since 0
 */

public class GreenDaoManager {
    private static final String DB_NAME = "pinan.db";
    private static GreenDaoManager mInstance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static GreenDaoManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager(context);
                }
            }
        }
        return mInstance;
    }

    private GreenDaoManager() {
        //        if(mInstance==null){
        //            daoMaster=new DaoMaster()
        //            daoSession = daoMaster.newSession();
        //        }
    }

    private GreenDaoManager(Context context) {
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "pinan.db", null);
            PinanDBHelper pinanDBHelper = new PinanDBHelper(context, "pinan.db", null);
            daoMaster = new DaoMaster(pinanDBHelper.getWritableDb());
            daoSession = daoMaster.newSession();
        }
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }
}
