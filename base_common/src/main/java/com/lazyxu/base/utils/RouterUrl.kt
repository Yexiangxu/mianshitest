package com.lazyxu.base.utils

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description: 不同的module需要用不同的group（eg：不同的module用相同的group跳转失败）
 * FIXME
 */
object RouterUrl {

    const val HOTFILM = "/film/hot"
    const val WEBVIEWMAIN = "/base/webviewmain"


    /**
     * 个人中心
     */
    const val LOGIN = "/user/login"
    const val SETTING = "/user/setting"
}
