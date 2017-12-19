package com.bidostar.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.bidostar.dblibrary.bean.CarBean
import com.bidostar.dblibrary.bean.UserBean
import com.bidostar.dblibrary.db.UserBeanDao
import com.bidostar.dblibrary.manager.GreenDaoManager
import kotlinx.android.synthetic.main.activity_dbtest.*

@Route(path = "/main/DBTestActivity")
class DBTestActivity : AppCompatActivity() {
    private var mIndex: Long = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbtest)
        val userDao = GreenDaoManager.getInstance(this).daoSession.userBeanDao
        val carDao = GreenDaoManager.getInstance(this).daoSession.carBeanDao
        btn_query_all.setOnClickListener {
            val loadAll = userDao.loadAll()
            tv_message.text = ""
            tv_message.text = "USER_LIST:" + loadAll.size + "\n"
            loadAll.forEach { t: UserBean? ->
                tv_message.append("用户:" + t?.toString() + "\n")
            }

        }
        btn_insert.setOnClickListener {
            val userBean = UserBean()
//            userBean.id = 0
            mIndex++
            userBean.address = "北京市海淀区" + mIndex
            userBean.age = 25 + mIndex.toInt()
            userBean.name = "张三" + mIndex
            userBean.sex = 1
            userBean.fuck = "成都,带不走的"
            userBean.maxAge = 10001
            userBean.signature = "和我在成都的街头走一走"
            userBean.chineseScore = 89
            userBean.chineseName = "语文学科"
            val insert = userDao.insert(userBean)
            tv_message.text = ""
            tv_message.text = "插入数据:" + insert
        }
        btn_query_one.setOnClickListener {
            val condition = et_condition.text.trim()
            if (condition.isEmpty()) {
                return@setOnClickListener
            }
            val query = userDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(condition)).build()
//
            val list = query.list()
            Log.d("DBTestActivity", "查询数据list:" + list.size)
            tv_message.text = "查询数据list:" + list.size + "\n"
            if (list.size > 1) {
                val userBean1 = list?.get(0)

                tv_message.append("查询数据userBean:" + userBean1?.toString())

                Log.d("DBTestActivity", "查询数据userBean:" + userBean1?.toString())
            }

        }
        btn_insert_car.setOnClickListener {
            val carBean = CarBean()
            carBean.brand = "jeep"
            carBean.carId = 100
            carBean.name = "jeep 自由光"
            val insert = carDao.insert(carBean)
            tv_message.text = ""
            tv_message.text = "插入数据:" + insert
        }
        btn_query_car.setOnClickListener {
            val loadAll = carDao.loadAll()

            Log.d("DBTestActivity", "car loadAll.size:" + loadAll.size)

            loadAll.forEach { t: CarBean? ->
                tv_message.append("车辆:" + t?.toString() + "\n")
            }

        }
    }
}
