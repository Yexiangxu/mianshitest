package com.lazyxu.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.lazyxu.base.base.BaseApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * User: xuyexiang
 * Date: 2019/06/12
 * Description:
 * FIXME 同时保存多个值最好最后统一apply
 */
public class SpUtil {
    private static final String DEFAULT_STRING_VALUE = "";
    private static final int DEFAULT_INT_VALUE = -1;
    private static final double DEFAULT_DOUBLE_VALUE = -1d;
    private static final float DEFAULT_FLOAT_VALUE = -1f;
    private static final long DEFAULT_LONG_VALUE = -1L;
    private static final boolean DEFAULT_BOOLEAN_VALUE = false;
    private static SharedPreferences sharedPreferences;
    private static SpUtil spUtilInstance;

    private SpUtil(@NonNull Context context) {
//        sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance());
        sharedPreferences = context.getApplicationContext().getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
    }

    private SpUtil(@NonNull Context context, @NonNull String preferencesName) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(context.getPackageName() + preferencesName, Context.MODE_PRIVATE);
    }


    public static SpUtil getInstance(@NonNull Context context) {
        if (spUtilInstance == null) {
            synchronized (SpUtil.class) {
                if (spUtilInstance == null) {
                    spUtilInstance = new SpUtil(context);
                }
            }
        }
        return spUtilInstance;
    }

    public static SpUtil getInstance(@NonNull Context context, @NonNull String preferencesName) {
        if (spUtilInstance == null) {
            synchronized (SpUtil.class) {
                if (spUtilInstance == null) {
                    spUtilInstance = new SpUtil(context, preferencesName);
                }
            }
        }
        return spUtilInstance;
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, DEFAULT_STRING_VALUE);
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public void put(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }


    public int getInt(String key) {
        return sharedPreferences.getInt(key, DEFAULT_INT_VALUE);
    }


    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public void put(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }


    public double getDouble(String key) {
        if (!contains(key)) {
            return DEFAULT_DOUBLE_VALUE;
        }
        return Double.longBitsToDouble(getLong(key));
    }

    public double getDouble(String key, double defaultValue) {
        if (!contains(key)) {
            return defaultValue;
        }
        return Double.longBitsToDouble(getLong(key));
    }


    public void put(String key, double value) {
        put(key, Double.doubleToRawLongBits(value));
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, DEFAULT_FLOAT_VALUE);
    }

    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public void put(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, DEFAULT_LONG_VALUE);
    }

    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public void put(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN_VALUE);
    }

    public boolean getBoolean(String what, boolean defaultBoolean) {
        return sharedPreferences.getBoolean(what, defaultBoolean);
    }

    public void put(String where, boolean what) {
        sharedPreferences.edit().putBoolean(where, what).apply();
    }

    public static void remove(String... keys) {
        if (keys != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            for (String key : keys) {
                editor.remove(key);
            }
            editor.apply();
        }
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    /**
     * 保存对象
     */
    public static boolean putObject(String key, Serializable ser) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = BaseApplication.getInstance().openFileOutput(key, BaseApplication.getInstance().MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ser);
            oos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public static void deleteObject(String key) {
        String filePath = BaseApplication.getInstance().getFilesDir().getPath() + "/" + key;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 读取对象
     */
    public static Serializable getObject(String key) {
        if (!isExistDataCache(key)) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = BaseApplication.getInstance().openFileInput(key);
            ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
            // 反序列化失败 - 删除缓存文件
            if (e instanceof InvalidClassException) {
                File data = BaseApplication.getInstance().getFileStreamPath(key);
                data.delete();
            }
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * 判断缓存是否存在
     */
    public static boolean isExistDataCache(String key) {
        if (BaseApplication.getInstance() == null) {
            return false;
        }
        boolean exist = false;
        File data = BaseApplication.getInstance().getFileStreamPath(key);
        if (data.exists()) {
            exist = true;
        }
        return exist;
    }

    private boolean contains(final String key) {
        return sharedPreferences.contains(key);
    }
}

