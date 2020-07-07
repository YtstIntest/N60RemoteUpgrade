package com.example.remoteupgradesdk.api;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateProgressBean;
import com.example.remoteupgradesdk.bean.UpdateResultBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.bean.VerIformationBean;
import com.example.remoteupgradesdk.bean.WebStateBean;
import com.example.remoteupgradesdk.callback.JsonCallback;
import com.example.remoteupgradesdk.configs.DataBackResult;
import com.example.remoteupgradesdk.configs.OkHelper;
import com.example.remoteupgradesdk.interfaces.ResponseCallback;
import com.example.remoteupgradesdk.utils.MTimerTask;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;


public class RemoteUpdateManage {
    private Context context;
    private List<MTimerTask> tasks = new ArrayList<>();


    public RemoteUpdateManage(Context context) {
        this.context = context;
    }


    public void initOtaSDK(Application application,String name)  {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OTA_SDK_LOG");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        try {
            HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(context.getAssets().open(name));
            builder.sslSocketFactory(sslParams.sSLSocketFactory,sslParams.trustManager);
            Log.e("OTA_SDK_LOG","证书加载成功！！！");
        }catch (IOException e){
            e.printStackTrace();
            Log.e("OTA_SDK_LOG","证书加载失败！！！");

        }
        OkGo.getInstance().init(application).setOkHttpClient(builder.build());




    }


    /**
     * @param vin       车辆VIN
     * @param taskCarId 车辆任务id
     * @param uDate     操作时间
     * @Description: 查询平台状态
     * @Description:
     * @Author: XL
     * @CreateDate: 2019/10/26 9:39 AM
     */
    public void queryState(String vin, String taskCarId, String uDate, final ResponseCallback<WebStateBean> callback) {
        OkHelper.queryState(context, vin, taskCarId, uDate, new JsonCallback<DataBackResult<WebStateBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<WebStateBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<WebStateBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });


    }


    /**
     * @param vin       车辆VIN
     * @param taskCarId 车辆任务id
     * @param uDate     操作时间
     * @Description: 获取车辆升级信息
     * @Author: XL
     * @CreateDate: 2019/9/19 3:50 PM
     */
    public void getCarUpdateTask(String vin, String taskCarId, String uDate, final ResponseCallback<CurrentVehicleTaskResBean> callback) {
        OkHelper.queryCarUpdateTask(context, vin, uDate, taskCarId, new JsonCallback<DataBackResult<CurrentVehicleTaskResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<CurrentVehicleTaskResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });

    }

    /**
     * @param vin   车辆VIN
     * @param uDate 操作时间
     * @Description: 获取当前版本信息
     * @Author: XL
     * @CreateDate: 2019/10/26 12:15 PM
     */
    public void getVersionInformation(String vin, String uDate, final ResponseCallback<VerIformationBean> callback) {
        OkHelper.getVersionInformation(context, vin, "", uDate, new JsonCallback<DataBackResult<VerIformationBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<VerIformationBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<VerIformationBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });

    }


    /**
     * @param vin       车辆VIN
     * @param taskCarId 车辆任务id
     * @param uDate     操作时间
     * @desc 查询升级进度
     * @author XL
     * @create_time 2019/4/13
     */
    public void queryUpdateProgress(String vin, String taskCarId, String uDate, ResponseCallback<UpdateProgressBean> callback) {
        MTimerTask task = new MTimerTask(context, vin, taskCarId, uDate, callback);
        tasks.add(task);
        task.start();
    }


    /**
     * @param vin       车辆VIN
     * @param taskCarId 车辆任务id
     * @param uDate     操作时间
     * @Description: 查询升级结果
     * @Author: XL
     * @CreateDate: 2019/10/26 9:58 AM
     */
    public void queryUpdateResult(String vin, String taskCarId, String uDate, final ResponseCallback<UpdateResultBean> callback) {
        OkHelper.queryUpdateResult(context, vin, uDate, taskCarId, new JsonCallback<DataBackResult<UpdateResultBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateResultBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<UpdateResultBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });


    }


    /**
     * @param vin   车辆VIN
     * @param pi    页面索引
     * @param ps    页面大小
     * @param uDate 日期时间
     * @desc 获取历史升级信息
     * @author XL
     * @create_time 2019/4/13
     */
    public void getHistoryUpdate(String vin, int pi, int ps, String uDate, final ResponseCallback<UpdateVehicleTasksResBean> callback) {
        OkHelper.getUpdateTaskList(context, vin, pi, ps, uDate, new JsonCallback<DataBackResult<UpdateVehicleTasksResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<UpdateVehicleTasksResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });
    }


    /**
     * @param taskcarId 车辆任务id
     * @param uDate     操作时间
     * @param type      确认类型
     * @param result    确认结果
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public void confirmUpgrade(String taskcarId, String uDate, int type, int result, final ResponseCallback<UpdateConfirInterfaceResBean> callback) {
        OkHelper.confirmUpgrade(context, taskcarId, uDate, type, result, new JsonCallback<DataBackResult<UpdateConfirInterfaceResBean>>() {
            @Override
            public void onSuccess(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                switch (response.body().getStatusCode()) {
                    case OkHelper.SUCCESS:
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
            public void onError(Response<DataBackResult<UpdateConfirInterfaceResBean>> response) {
                super.onError(response);
                callback.onError(OkHelper.ERRO_MESSAGE);
            }
        });
    }


    /**
     * @desc 清理任务（停止任务）
     * @author XL
     * @create_time 2019/4/17
     */
    public void clearTask() {
        if (tasks.size() != 0) {
            for (MTimerTask task : tasks) {
                task.stop();
            }
        }
    }


}
