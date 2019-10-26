package com.example.remoteupgradesdk.configs;

public class URLConfig {
    public static String IP = "http://113.57.170.58";


    public static String PORT_LASGING = ":62070/api/fota/";//联调环境

    public static String IP_PORT_LASGING = IP + PORT_LASGING;


    /**
     * @desc 查询车辆升级任务信息
     * @author XL
     * @create_time 2019/4/27
     */
    public static String s1 = IP_PORT_LASGING + "s1";

    /**
     * @desc 确认升级任务
     * @author XL
     * @create_time 2019/4/27
     */
    public static String s2 = IP_PORT_LASGING + "s2";

    /**
     * @desc 获取历史升级记录
     * @author XL
     * @create_time 2019/4/27
     */
    public static String s3 = IP_PORT_LASGING + "s3";

}
