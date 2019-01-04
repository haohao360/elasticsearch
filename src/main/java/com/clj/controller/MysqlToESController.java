package com.clj.controller;
/*package com.build.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.build.service.ProjectService;

@RestController
public class MysqlToESController {

	@RequestMapping("/project/mysqltoes")
	public void insertBigData() {
		//如果使用默认的cluster请保持Setting Empty
		Settings settings = Settings.EMPTY;
		TransportClient client;
		try {	
			//TransportClient连接es
			client = createConnection(settings,"192.168.1.179",9300);
			//调用插入大量数据方法
			String message = insertSomeRecords(client);
			//关闭连接
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private TransportClient createConnection(Settings settings,String ip,int port) throws UnknownHostException{
		TransportClient client = new PreBuiltTransportClient(settings)
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip),port));
		return client;
	}
	
	@Autowired
	private ProjectService projectService;
	
	private String insertSomeRecords(TransportClient client){
		// 定义你的elasticsearch 的  index 和 type
		String index = "xiaoqu";
		String type = "project";
		// 创建一个Json的list, 插入自己从MySql数据库查出的数据
		List<Map<String,Object>> userList = projectService.findProjectAll();
		Long count = (long) userList.size();		
		//核心方法BulkRequestBuilder拼接多个Json
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		for (int i = 0; i < count; i++) {
			System.out.println(userList.get(i).toString());
		    bulkRequest.add(client.prepareIndex(index, type).setSource(userList.get(i)).request());
		}
		//插入文档至ES, 完成！
		BulkResponse bulk = bulkRequest.get();
		return bulk.toString();
	}

}
*/

