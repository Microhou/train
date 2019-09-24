package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.bottom.*

class GroupActivity :FragmentActivity(),View.OnClickListener {
    //初始化4个Fragment
    private val tab01: Fragment? = null
    private val tab02: Fragment? = null
    private val tab03: Fragment? = null
    private val tab04: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupsetting)
        initEvents()
        setSelect(0)//默认显示微信聊天界面
    }

    private fun initEvents(){
        re_weixin.setOnClickListener(this)
        re_contact_list.setOnClickListener(this)
        re_find.setOnClickListener(this)
        re_profile.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.re_weixin -> setSelect(0)
            R.id.re_contact_list -> setSelect(1)
            R.id.re_find -> setSelect(2)
            R.id.re_profile ->setSelect(3)
        }
    }

    fun setSelect(i:Int){
       var transaction = supportFragmentManager.beginTransaction()
        hideFragment(transaction)
        when(i){
            0 -> if(tab01 ==null){
                val tab01 = WeixinFragment()
                transaction.add(R.id.id_content,tab01)
                }else{
                transaction.show(tab01)
                }
            1 -> if(tab02 ==null){
                val tab02 =FrdFragment()
                transaction.add(R.id.id_content,tab02)
            }else{
                transaction.show(tab02)
            }
        }

    }

    fun hideFragment(transaction: FragmentTransaction){
        if (tab01 != null) {
            transaction.hide(tab01)
        }
        if (tab02 != null) {
            transaction.hide(tab02)
        }
        if (tab03 != null) {
            transaction.hide(tab03)
        }
        if (tab04 != null) {
            transaction.hide(tab04)
        }
    }
}
