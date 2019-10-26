package com.example.remoteupgradesdk.bean;

public class WebStateBean {


    public static class BodyBean {
        /**
         * result : {"taskCarId":null,"taskType":0,"cVer":"1.012.1","nVer":"","size":0,"description":"","duration":0,"status":0,"progress":0,"result":0,"isNewTask":0,"time":""}
         * total : 0
         * code : 0
         * msg : 查询数据为空
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
             * taskCarId : null
             * taskType : 0.0
             * cVer : 1.012.1
             * nVer :
             * size : 0.0
             * description :
             * duration : 0.0
             * status : 0
             * progress : 0.0
             * result : 0
             * isNewTask : 0
             * time :
             */

            private int status;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
