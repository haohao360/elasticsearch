package com.clj.controller;

public class ESController {
	
	
	
//	/** * mysql传输到elasticsearch * @param str */ 
//	public void testSimpleLogImportBuilderFromExternalDBConfig(String str){
//		ImportBuilder importBuilder = ImportBuilder.newInstance();
//		//数据源相关配置，可选项，可以在外部启动数据源 
//		importBuilder.setDbName("test") .setDbDriver("com.mysql.jdbc.Driver")//数据库驱动程序，必须导入相关数据库的驱动jar包 
//		.setDbUrl("jdbc:mysql://localhost:3306/me?useCursorFetch=true")//通过useCursorFetch=true启用mysql的游标fetch机制，否则会有严重的性能隐患，useCursorFetch必须和jdbcFetchSize参数配合使用，否则不会生效 
//		.setDbUser("root")
//		.setDbPassword("root")
//		.setValidateSQL("select 1")
//		.setUsePool(false);//是否使用连接池 
//		//指定导入数据的sql语句，必填项，可以设置自己的提取逻辑 
//		importBuilder.setSql("select * from "+str); /** * es相关配置 */ 
//		importBuilder .setIndex(str) //必填项 
//		.setIndexType(str) //必填项 
//		.setRefreshOption(null)//可选项，null表示不实时刷新，importBuilder.setRefreshOption("refresh");表示实时刷新 
//		.setUseJavaName(true) //可选项,将数据库字段名称转换为java驼峰规范的名称，例如:doc_id -> docId 
//		.setBatchSize(5000) //可选项,批量导入es的记录数，默认为-1，逐条处理，> 0时批量处理 
//		.setJdbcFetchSize(10000);//设置数据库的查询fetchsize，同时在mysql url上设置useCursorFetch=true启用mysql的游标fetch机制，否则会有严重的性能隐患，jdbcFetchSize必须和useCursorFetch参数配合使用，否则不会生效 /** * 一次、作业创建一个内置的线程池，实现多线程并行数据导入elasticsearch功能，作业完毕后关闭线程池 */ 
//		importBuilder.setParallel(true);//设置为多线程并行批量导入 
//		importBuilder.setQueue(100);//设置批量导入线程池等待队列长度 
//		importBuilder.setThreadCount(200);//设置批量导入线程池工作线程数量 
//		importBuilder.setContinueOnError(true);//任务出现异常，是否继续执行作业：true（默认值）继续执行 false 中断作业执行 
//		importBuilder.setAsyn(false);//true 异步方式执行，不等待所有导入作业任务结束，方法快速返回；false（默认值） 同步方式执行，等待所有导入作业任务结束，所有作业结束后方法才返回 
//		importBuilder.setRefreshOption("refresh"); // 为了实时验证数据导入的效果，强制刷新数据，生产环境请设置为null或者不指定 /** * 执行数据库表数据导入es操作 */ 
//		DataStream dataStream = importBuilder.builder(); 
//		dataStream.db2es(); 
//		
//	}
}


