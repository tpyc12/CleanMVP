package com.myhome.android.clean.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler
}