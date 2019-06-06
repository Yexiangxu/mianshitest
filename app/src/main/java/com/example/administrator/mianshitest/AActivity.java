package com.example.administrator.mianshitest;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.util.Auth;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.nereo.multi_image_selector.MultiImageSelector;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;


public class AActivity extends AppCompatActivity {

    Button uploadButton;
    private RxPermissions rxPermissions;
    private File uploadfile1 = null, uploadfile2 = null, uploadfile3 = null;
    private UploadManager uploadManager;
    private long lasttime;
    private ImageView ivUpload1, ivUpload2, ivUpload3;
    private ImageView ivLrucache1, ivLrucache2, ivLrucache3;
    private  boolean uploadSuc1 = false;
    private  boolean uploadSuc2 = false;
    private  boolean uploadSuc3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConfig();
        ivLrucache1.setOnClickListener(v -> {
            rxPermissions.request(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
            }).subscribe(granted -> {
                if (granted) {
                    MultiImageSelector selector = MultiImageSelector.create();
                    selector.showCamera(true);
                    selector.single();
                    selector.start(AActivity.this, 1);
                } else {
                    Toast.makeText(AActivity.this, "请前去打开拍照等权限", Toast.LENGTH_SHORT).show();
                }
            }, throwable -> {
            });
        });
        ivLrucache2.setOnClickListener(v -> {
            rxPermissions.request(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
            }).subscribe(granted -> {
                if (granted) {
                    MultiImageSelector selector = MultiImageSelector.create();
                    selector.showCamera(true);
                    selector.single();
                    selector.start(AActivity.this, 2);
                } else {
                    Toast.makeText(AActivity.this, "请前去打开拍照等权限", Toast.LENGTH_SHORT).show();
                }
            }, throwable -> {
            });
        });
        ivLrucache3.setOnClickListener(v -> {
            rxPermissions.request(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
            }).subscribe(granted -> {
                if (granted) {
                    MultiImageSelector selector = MultiImageSelector.create();
                    selector.showCamera(true);
                    selector.single();
                    selector.start(AActivity.this, 3);
                } else {
                    Toast.makeText(AActivity.this, "请前去打开拍照等权限", Toast.LENGTH_SHORT).show();
                }
            }, throwable -> {
            });
        });
        uploadButton.setOnClickListener(v -> {
            if (uploadfile1 != null && uploadfile2 != null && uploadfile3 != null) {
                uploadSuc1 = false;
                uploadSuc2 = false;
                uploadSuc3 = false;
                lasttime = System.currentTimeMillis();
                Flowable.fromArray(uploadfile1, uploadfile2, uploadfile3)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(file -> {
                            if (file == uploadfile1) {
                                uploadManager.put(file, "uploadfile1" + System.currentTimeMillis(), upToken, (key, info, response) -> {
                                    Log.d("step", "onNext 1" );
                                    uploadSuc1 = true;
                                    judgeTime();
                                    Glide.with(AActivity.this).asBitmap().load("https://adminimg.358fintech.com/" + key).into(ivUpload1);
                                }, null);
                            } else if (file == uploadfile2) {
                                uploadManager.put(file, "uploadfile2" + System.currentTimeMillis(), upToken, (key, info, response) -> {
                                    Log.d("step", "onNext 2" );
                                    uploadSuc2 = true;
                                    judgeTime();
                                    Glide.with(AActivity.this).asBitmap().load("https://adminimg.358fintech.com/" + key).into(ivUpload2);
                                }, null);
                            } else if (file == uploadfile3) {
                                uploadManager.put(file, "uploadfile3" + System.currentTimeMillis(), upToken, (key, info, response) -> {
                                    Log.d("step", "onNext 3" );
                                    uploadSuc3 = true;
                                    judgeTime();
                                    Glide.with(AActivity.this).asBitmap().load("https://adminimg.358fintech.com/" + key).into(ivUpload3);
                                }, null);
                            }
                        }, throwable -> Toast.makeText(AActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(AActivity.this, "请前去选择图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void judgeTime() {
        if (uploadSuc1 && uploadSuc2 && uploadSuc3) {
            uploadButton.setText("上传图片用了" + (System.currentTimeMillis() - lasttime) + " ms");
        }
    }

    private void initConfig() {
        uploadButton = findViewById(R.id.hide_button);
        ivUpload1 = findViewById(R.id.iv_upload1);
        ivUpload2 = findViewById(R.id.iv_upload2);
        ivUpload3 = findViewById(R.id.iv_upload3);
        ivLrucache1 = findViewById(R.id.iv_lrucache1);
        ivLrucache2 = findViewById(R.id.iv_lrucache2);
        ivLrucache3 = findViewById(R.id.iv_lrucache3);
        Configuration config = new Configuration.Builder()
                .connectTimeout(30)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(30)          // 服务器响应超时。默认60秒
                .zone(FixedZone.zoneAs0)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();
        uploadManager = new UploadManager(config);

        Auth auth = Auth.create(accessKey, secretKey);
        upToken = auth.uploadToken("mmfq-eb-admin");
        rxPermissions = new RxPermissions(AActivity.this);


    }

    private static String accessKey = "o9QolG8yYMGKS8a9wLAEmMoxAOQ3KLPko74wjn9x";
    private static String secretKey = "j8toKPxOxHqGzcK3iqlPKXK5_prIyDBnmMs5B-gw";
    private String upToken;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Luban.with(AActivity.this)
                    .filter(path -> !TextUtils.isEmpty(path))
                    .load(data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT).get(0))
                    .ignoreBy(100)
                    .setCompressListener(new OnCompressListener() {
                        @Override
                        public void onStart() {
                        }

                        @Override
                        public void onSuccess(File file) {
                            if (requestCode == 1) {
                                uploadfile1 = file;
                                Glide.with(AActivity.this).asBitmap().load(uploadfile1).into(ivLrucache1);
                            } else if (requestCode == 2) {
                                uploadfile2 = file;
                                Glide.with(AActivity.this).asBitmap().load(uploadfile2).into(ivLrucache2);
                            } else if (requestCode == 3) {
                                uploadfile3 = file;
                                Glide.with(AActivity.this).asBitmap().load(uploadfile3).into(ivLrucache3);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(AActivity.this, "压缩失败了", Toast.LENGTH_SHORT).show();
                        }
                    }).launch();
        }
    }
}
