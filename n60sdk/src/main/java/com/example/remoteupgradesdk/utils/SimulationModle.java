package com.example.remoteupgradesdk.utils;

import com.example.remoteupgradesdk.bean.CurrentVehicleTaskResBean;
import com.example.remoteupgradesdk.bean.UpdateConfirInterfaceResBean;
import com.example.remoteupgradesdk.bean.UpdateProgressBean;
import com.example.remoteupgradesdk.bean.UpdateResultBean;
import com.example.remoteupgradesdk.bean.UpdateVehicleTasksResBean;
import com.example.remoteupgradesdk.bean.VerIformationBean;
import com.example.remoteupgradesdk.bean.WebStateBean;

import java.util.ArrayList;
import java.util.List;

public class SimulationModle {

    public WebStateBean getWebStateBean(int status) {
        WebStateBean bean = new WebStateBean();
        bean.setCode(1);
        bean.setMsg("获取到状态");
        WebStateBean.ResultBean resultBean = new WebStateBean.ResultBean();
        resultBean.setStatus(status);
        bean.setResult(resultBean);

        return bean;
    }

    public CurrentVehicleTaskResBean getCurrentVehicleTaskResBean() {
        CurrentVehicleTaskResBean bean = new CurrentVehicleTaskResBean();
        bean.setCode(1);
        bean.setMsg("获取到最新升级信息");
        bean.setTotal(1);
        CurrentVehicleTaskResBean.ResultBean resultBean = new CurrentVehicleTaskResBean.ResultBean();
        resultBean.setTaskCarId("05d2bf95-a152-4dde-8f9e-a514b39bc88a");
        resultBean.setTaskType(0);
        resultBean.setNVer("1.012.5");
        resultBean.setSize(100);
        resultBean.setDescription("更新说明");
        resultBean.setDuration(50);
        resultBean.setIsNewTask(1);
        resultBean.setTime("2019年9月4号 09:36");
        bean.setResult(resultBean);

        return bean;
    }

    public VerIformationBean getVerIformationBean() {
        VerIformationBean bean = new VerIformationBean();
        bean.setCode(1);
        bean.setMsg("获取到当前版本");
        VerIformationBean.ResultBean resultBean = new VerIformationBean.ResultBean();
        resultBean.setCVer("1.012.4");
        bean.setResult(resultBean);
        return bean;
    }

    public UpdateProgressBean getUpdateProgressBean(String vin, int progress) {
        UpdateProgressBean bean = new UpdateProgressBean();
        bean.setCode(1);
        bean.setMsg("查询到升级进度值");
        UpdateProgressBean.ResultBean resultBean = new UpdateProgressBean.ResultBean();
        resultBean.setVin(vin);
        resultBean.setProgress(progress);
        bean.setResult(resultBean);
        return bean;
    }

    public UpdateResultBean getUpdateResultBean() {
        UpdateResultBean bean = new UpdateResultBean();
        bean.setCode(1);
        bean.setMsg("获取到升级结果");
        UpdateResultBean.ResultBean resultBean = new UpdateResultBean.ResultBean();
        resultBean.setResult(1);
        bean.setResult(resultBean);
        return bean;
    }

    public UpdateVehicleTasksResBean getUpdateVehicleTasksResBean() {
        UpdateVehicleTasksResBean bean = new UpdateVehicleTasksResBean();
        bean.setCode(1);
        bean.setMsg("查询历史升级记录");
        bean.setTotal(5);
        List<UpdateVehicleTasksResBean.ResultBean> list = new ArrayList<>();

        UpdateVehicleTasksResBean.ResultBean resultBean1 = new UpdateVehicleTasksResBean.ResultBean();
        resultBean1.setDescription("任务说明");
        resultBean1.setIndex(1);
        resultBean1.setStatus(1);
        resultBean1.setUpgradeDate("2019年9月18号 09:36");
        resultBean1.setTaskCarId("3a523d8a-5ce1-4a9b-bec9-75b64c7c8dde");
        list.add(resultBean1);

        UpdateVehicleTasksResBean.ResultBean resultBean2 = new UpdateVehicleTasksResBean.ResultBean();
        resultBean2.setDescription("任务说明");
        resultBean2.setIndex(2);
        resultBean2.setStatus(0);
        resultBean2.setUpgradeDate("2019年9月12号 09:36");
        resultBean2.setTaskCarId("3a523d8a-5ce1-4apb-bec9-75b64c7c8dde");
        list.add(resultBean2);

        UpdateVehicleTasksResBean.ResultBean resultBean3 = new UpdateVehicleTasksResBean.ResultBean();
        resultBean3.setDescription("任务说明");
        resultBean3.setIndex(3);
        resultBean3.setStatus(1);
        resultBean3.setUpgradeDate("2019年9月10号 09:36");
        resultBean3.setTaskCarId("3a523d8a-5ce1-4akb-bec9-75b64c7c8dde");
        list.add(resultBean3);

        UpdateVehicleTasksResBean.ResultBean resultBean4 = new UpdateVehicleTasksResBean.ResultBean();
        resultBean4.setDescription("任务说明");
        resultBean4.setIndex(4);
        resultBean4.setStatus(-1);
        resultBean4.setUpgradeDate("2019年9月4号 09:36");
        resultBean4.setTaskCarId("3a523d8a-5ce1-4d8b-bec9-75b64c7c8dde");
        list.add(resultBean4);

        UpdateVehicleTasksResBean.ResultBean resultBean5 = new UpdateVehicleTasksResBean.ResultBean();
        resultBean5.setDescription("任务说明");
        resultBean5.setIndex(5);
        resultBean5.setStatus(1);
        resultBean5.setUpgradeDate("2019年9月11号 09:36");
        resultBean5.setTaskCarId("3a523d8a-5ce1-4a8c-bec9-75b64c7c8dde");
        list.add(resultBean5);
        bean.setResult(list);
        return bean;
    }

    public UpdateConfirInterfaceResBean getUpdateConfirInterfaceResBean() {
        UpdateConfirInterfaceResBean bean = new UpdateConfirInterfaceResBean();
        bean.setCode(1);
        bean.setMsg("确认升级任务");
        bean.setTotal(0);
        bean.setResult(null);
        return bean;
    }
}
