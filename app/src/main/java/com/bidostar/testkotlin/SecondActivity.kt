package com.bidostar.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/main/SecondActivity")
class SecondActivity : AppCompatActivity() {
    var mIndex: Long = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_message.text = "这是第二个页面"
        btn_message.setOnClickListener {
            ARouter.getInstance().build("/main/DBTestActivity").navigation()
        }
        btn_go_module1.setOnClickListener {
            ARouter.getInstance().build("/module1/Module1Activity").navigation()
            finish()
        }
        btn_go_module2.setOnClickListener {
            ARouter.getInstance().build("/module2/Module2Activity").navigation()
            finish()
        }
//        val userDao = GreenDaoManager.getInstance(this).daoSession.userBeanDao
//        val loadAll = userDao.loadAll()
//        Log.d("SecondActivity", "查询所有loadAll:" + loadAll.size)
//        val userBean = UserBean()
//        userBean.id = mIndex++
//        userBean.address = "北京市海淀区" + mIndex
//        userBean.age = 25 + mIndex.toInt()
//        userBean.name = "张三" + mIndex
//        val insert = userDao.insert(userBean)
//        Log.d("SecondActivity", "插入数据:" + insert)
//        val loadAll1 = userDao.loadAll()
//        Log.d("SecondActivity", "查询所有loadAll1:" + loadAll1.size)
//        val query = userDao.queryBuilder().where(UserBeanDao.Properties.Name.eq("张三")).build()
//
//        val list = query.list()
//        Log.d("SecondActivity", "查询数据list:" + list.size)
//        val userBean1 = list[0]
//        Log.d("SecondActivity", "查询数据userBean:" + userBean1.toString())


    }
}
