package com.schedule.testtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * 定时任务的使用
 * @author pan_junbiao
 **/
@Component
public class Task
{
    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void execute(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
        System.out.println("欢迎访问 " + df.format(new Date()));
    }
}