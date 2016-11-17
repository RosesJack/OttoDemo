package com.example.administrator.ottodemo;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * auther：wzy
 * date：2016/11/17 18 :26
 * desc: 设置主线程总线
 */

public class MainThreadBus extends Bus {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        //判断是否是主线程looper,就是本线程是否是主线程
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadBus.super.post(event);
                }
            });
        }
    }
}
