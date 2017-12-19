package com.bidostar.module2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_moudle2.*

@Route(path = "/module2/Module2Activity")
class Module2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moudle2)
        btn_go_main.setOnClickListener {
            ARouter.getInstance().build("/main/SecondActivity").navigation()
            finish()
        }
        btn_go_module1.setOnClickListener {
            ARouter.getInstance().build("/module1/Module1Activity").navigation()
            finish()
        }
    }
}
