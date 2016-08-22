package com.smart.share.stormesper.bolt;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.smart.share.stormesper.IPBean;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class IPBolt extends BaseRichBolt implements UpdateListener{
	
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(IPBolt.class);
	
	private OutputCollector _collector;
	private EPServiceProvider epService;
	private String[] EPLString = null; 
	
	public void setUpEsper(){
		Configuration configuration = new Configuration();
		configuration.addEventType("IP", IPBean.class.getName());
		
		epService = EPServiceProviderManager.getDefaultProvider(configuration);
		epService.initialize();
		epService.getEPAdministrator().createEPL("");
	}

	@Override
	public void execute(Tuple tuple) {
		epService.getEPRuntime().sendEvent(null);
		_collector.ack(tuple);
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector _collector) {
		this._collector = _collector;

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {

	}

	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {

		if (arg0 != null) {
			for (EventBean e : arg0) {  //
				
			}
		}
	
	}

}
