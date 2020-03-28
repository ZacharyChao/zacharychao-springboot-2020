package com.zacharychao.demo.current.threadPoolTaskExecutor.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

	@Bean("getTaskExector")
	public Executor taskExecutor() {
		int threadCount = Runtime.getRuntime().availableProcessors();
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 核心线程池数量，方法: 返回可用处理器的Java虚拟机的数量。
		executor.setCorePoolSize(threadCount);
		// 最大线程数量
		executor.setMaxPoolSize(threadCount);
		// 线程池的队列容量
		executor.setQueueCapacity(200);
		executor.setKeepAliveSeconds(60);
		// 线程名称的前缀
		executor.setThreadNamePrefix("taskExecutor-");
		// setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
		// CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}

	/* 异步任务中异常处理 */
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}
