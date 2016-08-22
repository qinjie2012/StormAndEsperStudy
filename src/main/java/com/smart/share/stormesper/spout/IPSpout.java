package com.smart.share.stormesper.spout;

import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smart.share.stormesper.IPBean;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
/**
 * 
 * @author liujie
 *
 * 2016年8月20日
 *
 */
public class IPSpout extends BaseRichSpout{

	private static final Log log = LogFactory.getLog(BaseRichSpout.class);
	private LinkedList<IPBean> IPBeanBuff = new LinkedList<IPBean>();
	private SpoutOutputCollector _collector;
	@Override
	public void nextTuple() {

	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector _collector) {
		this._collector = _collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {

	}

	
	

}
