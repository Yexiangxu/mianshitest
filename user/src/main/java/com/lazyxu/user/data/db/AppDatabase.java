package com.lazyxu.user.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.lazyxu.user.data.db.dao.UserDao;
import com.lazyxu.user.data.entity.db.User;

/**
 * 注意：改变数据库结构要改变版本号,不然会抛异常
 */

@Database(entities = {User.class}, version = 2, exportSchema = false)//@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

