package com.bidostar.testkotlin

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.bidostar.dblibrary.db.UserBeanDao
import com.bidostar.dblibrary.manager.GreenDaoManager
import com.facebook.stetho.Stetho


/**
 * @author zsh27
 * @date 2017/12/18.
 * description .
 * @since 0
 */
class TestApplication : Application() {
    private var application: Application? = null
    lateinit var mUserDao: UserBeanDao
    override fun onCreate() {
        super.onCreate()

        application = this
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog()     // 打印日志
        ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(getApplication()) // 尽可能早，推荐在Application中初始化
        //创建dbmanager类初始化数据库
        GreenDaoManager.getInstance(this)
        Stetho.initializeWithDefaults(this)
//        val o = PinanDBHelper(this, "pinan.db", null)
//        val daoMaster = DaoMaster(o.getWritableDatabase())

//        val devOpenHelper = DaoMaster.DevOpenHelper(getApplication(), "pinan.db", null)
//        val daoMaster = DaoMaster(devOpenHelper.writableDb)
//        val daoSession = daoMaster.newSession()
//        mUserDao = daoSession.userBeanDao
    }

    companion object Factory{

    }

//    fun _UserDao(): UserBeanDao {
//        return mUserDao
//    }
    fun getApplication(): Application {
        return application!!
    }
}