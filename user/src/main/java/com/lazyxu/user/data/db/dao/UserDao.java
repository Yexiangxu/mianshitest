package com.lazyxu.user.data.db.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.lazyxu.user.data.entity.db.User;

/**
 * User: Lazy_xu
 * Data: 2019/08/05
 * Description:
 * FIXME
 */
@Dao
public interface UserDao {
    /**
     * 加入一条数据，如果主键值一样就替换，如果不一样就添加
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("SELECT * FROM User")
    User queryUser();
}
