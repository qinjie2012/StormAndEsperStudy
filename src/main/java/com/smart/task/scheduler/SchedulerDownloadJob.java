package com.smart.task.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.smart.task.DownloadJob;

/**
 * 主控调度下载股票数据的job
 * 
 * @author liujie
 *
 *         2016年9月15日
 *
 */
public class SchedulerDownloadJob {

	private static void go() throws SchedulerException {
		// 获取Scheduler实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		// 具体任务
		JobDetail job = JobBuilder.newJob(DownloadJob.class).withIdentity("job1", "group1").build();

		// 触发时间点
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
				.repeatForever();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow()
				.withSchedule(simpleScheduleBuilder).build();

		// 交由Scheduler安排触发
		scheduler.scheduleJob(job, trigger);
	}

	public static void main(String args[]) {

		try {
			go();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
