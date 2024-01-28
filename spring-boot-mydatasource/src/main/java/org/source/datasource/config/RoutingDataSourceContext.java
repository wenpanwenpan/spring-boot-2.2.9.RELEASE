package org.source.datasource.config;

/**
 * 动态路由上下文
 *
 * @author Mr_wenpan@163.com 2022/04/05 16:39
 */
public class RoutingDataSourceContext {

	static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

	/**
	 * key：当前指定的数据源
	 */
	public RoutingDataSourceContext(String  key){
		THREAD_LOCAL.set(key);
	}

	public static String getDataSourceRoutingKey(){
		String key = THREAD_LOCAL.get();
		// 如果当前线程上下文没有指定数据源，则使用默认值master
		return key == null ? "master":key;
	}

	public static void setThreadLocal(String lookUpKey){
		THREAD_LOCAL.set(lookUpKey);
	}

	public void close(){
		THREAD_LOCAL.remove();
	}

}
