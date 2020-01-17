package com.example.remoteupgradesdk.bean;

public class CurrentVehicleTaskResBean {


    /**
     * result : {"taskCarId":"05d2bf95-a152-4dde-8f9e-a514b39bc88a","taskType":0,"cVer":"","nVer":"","size":0,"description":null,"duration":0,"status":1,"progress":255,"result":-1,"isNewTask":1}
     * total : 1
     * code : 1
     * msg : null
     */

    private ResultBean result;
    private int total;
    private int code;
    private String msg;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ResultBean {
        /**
         * taskCarId : 05d2bf95-a152-4dde-8f9e-a514b39bc88a
         * taskType : 0
         * cVer :
         * nVer :
         * size : 0
         * description : null
         * duration : 0
         * status : 1
         * progress : 255
         * result : -1
         * isNewTask : 1
         * time: "2019-09-04T15:25:39.1259343+08:00"
         */

        private String taskCarId;
        private int taskType;
        private String nVer;
        private double size;
        private String description;
        private int duration;
        private int isNewTask;
        private String time;

        public String getTaskCarId() {
            return taskCarId;
        }

        public void setTaskCarId(String taskCarId) {
            this.taskCarId = taskCarId;
        }

        public int getTaskType() {
            return taskType;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        public String getNVer() {
            return nVer;
        }

        public void setNVer(String nVer) {
            this.nVer = nVer;
        }

        public double getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getIsNewTask() {
            return isNewTask;
        }

        public void setIsNewTask(int isNewTask) {
            this.isNewTask = isNewTask;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
