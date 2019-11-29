package com.example.remoteupgradesdk.utils;

import android.content.Context;

import com.example.remoteupgradesdk.bean.UpdateProgressBean;
import com.example.remoteupgradesdk.callback.JsonCallback;
import com.example.remoteupgradesdk.configs.DataBackResult;
import com.example.remoteupgradesdk.configs.OkHelper;
import com.example.remoteupgradesdk.interfaces.ResponseCallback;
import com.lzy.okgo.model.Response;

import java.util.Timer;
import java.util.TimerTask;

public class MTimerTask {
    private Timer timer;
    private TimerTask task;
    private static final int DELAY_TIME = 5 * 1000;


    public MTimerTask(final Context context, final String vin, final String taskCarId, final String uDate, final ResponseCallback<UpdateProgressBean> callback) {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                                OkHelper.queryUpdateProgress(context, vin, uDate, taskCarId, new JsonCallback<DataBackResult<UpdateProgressBean>>() {
                    @Override
                    public void onSuccess(Response<DataBackResult<UpdateProgressBean>> response) {
                        switch (response.body().getStatusCode()) {
                            case OkHelper.SUCCESS:
                                if (response.body().getBody().getResult() != null) {
                                    if (response.body().getBody().getResult().getProgress() == 100) {
                                        stop();
                                    }
                                    if (vin!=null){
                                        response.body().getBody().getResult().setVin(vin);
                                    }
                                }
                                callback.onSuccess(response.body().getBody());
                                break;
                            case OkHelper.ERRO_NOT_FOUNT:
                                callback.onError(OkHelper.ERRO_NOT_FOUNT_MESSAGE);
                                break;
                            case OkHelper.ERRO_SERVER:
                                callback.onError(OkHelper.ERRO_SERVER_MESSAGE);
                                break;
                            case OkHelper.ERRO_UPTATE:
                                callback.onError(OkHelper.ERRO_UPTATE_MESSAGE);
                                break;
                            default:
                                callback.onError(OkHelper.ERRO_NOT_MESSAGE);
                                break;
                        }

                    }

                    @Override
                    public void onError(Response<DataBackResult<UpdateProgressBean>> response) {
                        super.onError(response);
                        callback.onError(OkHelper.ERRO_MESSAGE);
                    }
                });
            }
        };

    }

    /**
     * @desc 启动任务
     * @author XL
     * @create_time 2019/4/16
     */
    public void start() {
        timer.schedule(task, 0, DELAY_TIME);//每隔time时间段就执行一次
    }

    /**
     * @desc 停止任务
     * @author XL
     * @create_time 2019/4/16
     */
    public void stop() {
        if (timer != null) {
            timer.cancel();
            if (task != null) {
                task.cancel();  //将原任务从队列中移除
            }
        }
    }
}
