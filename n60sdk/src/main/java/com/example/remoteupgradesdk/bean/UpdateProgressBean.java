package com.example.remoteupgradesdk.bean;

public class UpdateProgressBean {


    /**
     * result : {"taskCarId":"05d2bf95-a152-4dde-8f9e-a514b39bc88a","taskType":0,"cVer":"","nVer":"","size":0,"description":null,"duration":0,"status":1,"progress":255,"result":-1,"isNewTask":1}
     * total : 1
     * code : 1
     * msg : null
     */

    private ResultBean result;
    private int code;
    private String msg;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
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

        private String vin;
        private int result;
        private int resultCode;
        private int progress;


        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getResultCode() {
            return resultCode;
        }

        public void setResultCode(int resultCode) {
            this.resultCode = resultCode;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

    }


}
