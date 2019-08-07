package com.lazyxu.base.base.head;

/**
 * Author: wendjia
 * Time: 2018\9\4 0004
 * Description:
 **/
public class HeadToolbar {
    private int layoutId = -1;
    private int menuId = -1;
    private int toolbarTitle = -1;
    private int toolbarTitleSize = -1;
    private int toolbarTitleColor = -1;
    private int toolbarBgColor = -1;
    private int backDrawable = -1;
    private int loadingTargetView = -1;
    private int statusBarColor = -1;
    private boolean hideBack = false;


    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setToolbarTitleSize(int size) {
        this.toolbarTitleSize = size;
    }

    public int getToolbarTitle() {
        return toolbarTitle;
    }

    public void setToolbarTitle(int toolbarTitle) {
        this.toolbarTitle = toolbarTitle;
    }


    public void setToolbarTitleColor(int toolbarTitleColor) {
        this.toolbarTitleColor = toolbarTitleColor;
    }


    public void setToolbarBgColor(int toolbarBgColor) {
        this.toolbarBgColor = toolbarBgColor;
    }


    public void setBackDrawable(int backDrawable) {
        this.backDrawable = backDrawable;
    }


    public void setLoadingTargetView(int loadingTargetView) {
        this.loadingTargetView = loadingTargetView;
    }


    public void setStatusBarColor(int statusBarColor) {
        this.statusBarColor = statusBarColor;
    }


    public void setHideBack(boolean hideBack) {
        this.hideBack = hideBack;
    }


    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }
}
