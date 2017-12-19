package com.bidostar.dblibrary.helpter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bidostar.dblibrary.db.CarBeanDao;
import com.bidostar.dblibrary.db.DaoMaster;
import com.bidostar.dblibrary.db.UserBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * @author zsh27
 * @date 2017/12/18.
 * description .
 * @since 0
 */

public class PinanDBHelper extends DaoMaster.OpenHelper {
    public PinanDBHelper(Context context, String name) {
        super(context, name);
    }

    public PinanDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        if (oldVersion == newVersion) {
            Log.e("PinanDBHelper", "数据库是最新版本,无需升级");
            return;
        }
        Log.e("PinanDBHelper", "oldVersion:" + oldVersion + "----newVersion:" + newVersion);
        //        super.onUpgrade(db, oldVersion, newVersion);
        //        if (oldVersion == newVersion) {
        //            Log.e("onUpgrade", "数据库是最新版本,无需升级" );
        //            return;
        //        }
        /**
         * //数据版本变更才会执行
         */
        MigrationHelper.migrate(db, UserBeanDao.class, CarBeanDao.class);
    }
}
