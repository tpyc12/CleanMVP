package com.myhome.android.clean.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myhome.android.clean.model.data.AppState
import com.myhome.android.clean.presenter.Presenter

abstract class BaseActivity<T: AppState> : AppCompatActivity(), MvpView {
    // Храним ссылку на презентер
    protected lateinit var presenter: Presenter<T, MvpView>

    protected abstract fun createPresenter(): Presenter<T, MvpView>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    // Когда View готова отображать данные, передаём ссылку на View в презентер
    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    // При пересоздании или уничтожении View удаляем ссылку, иначе в презентере
    // будет ссылка на несуществующую View
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
    }

}