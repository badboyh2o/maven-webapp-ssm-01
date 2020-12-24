package com.nantian.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nantian.common.config.AppConfig;
import com.nantian.common.config.P10SvcConfig;
import com.nantian.common.service.HttpClientService;
import com.nantian.common.vo.ResultVO;
import com.nantian.service.P10DataService;
import com.nantian.util.DateUtil;
import com.nantian.util.XstreamUtil;
import com.nantian.vo.P10ReqParamVO;
import com.nantian.vo.P10ReqVO;
import com.nantian.vo.P10ResultDataVO;
import com.nantian.vo.p10.req.TxReqBodyCommon1VO;
import com.nantian.vo.p10.req.TxReqBodyCommon4VO;
import com.nantian.vo.p10.req.TxReqBodyCommon7VO;
import com.nantian.vo.p10.req.TxReqBodyCommonVO;
import com.nantian.vo.p10.req.TxReqBodyEntityVO;
import com.nantian.vo.p10.req.TxReqBodyVO;
import com.nantian.vo.p10.req.TxReqHeadVO;
import com.nantian.vo.p10.req.TxReqVO;
import com.nantian.vo.p10.resp.TxEnqrRstVO;
import com.nantian.vo.p10.resp.TxRespBodyCommonBVO;
import com.nantian.vo.p10.resp.TxRespBodyEntityVO;
import com.nantian.vo.p10.resp.TxRespVO;


@Service
public class P10DataServiceImpl implements P10DataService {
	
	private static Logger log = LoggerFactory.getLogger(P10DataServiceImpl.class);
	@Autowired
	private HttpClientService httpClientService;

	
	/**
	 * 调 总行P10 http接口，获取到数据后，封装为 ResultVO<P10ResultDataVO> 返回
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Override
	public ResultVO<P10ResultDataVO> getData(P10ReqVO req) throws ClientProtocolException, IOException {
		String reqXml = createP10ReqXml(req);
		log.info(reqXml);
		
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=" + AppConfig.A0831D023_ENCODING);
		// TODO 异常
		String respXml = httpClientService.doPost(AppConfig.A0831D023_URL, header, reqXml, AppConfig.A0831D023_ENCODING);
		TxRespVO txRespVO = XstreamUtil.xmlToBean(respXml, TxRespVO.class);
		ResultVO<P10ResultDataVO> p10DataResult = createP10DataResult(txRespVO);
		return p10DataResult;
	}

	
	/**
	 * 解析P10的响应,转换为 ResultVO<P10ResultDataVO>
	 * @param txRespVO
	 * @return
	 */
	private ResultVO<P10ResultDataVO> createP10DataResult(TxRespVO txRespVO) {
		// 返回结果
		ResultVO<P10ResultDataVO> result = ResultVO.getNewResultVO();
		
		// TODO
		result.setCode("0");
		result.setMsg("0");
		
		TxRespBodyCommonBVO txRespBodyCommonBVO = txRespVO.getTxRespBody().getTxRespBodyCommon().getTxRespBodyCommonBVO();
		
		P10ResultDataVO P10ResultDataVO = new P10ResultDataVO();
		P10ResultDataVO.setCurr_total_page(txRespBodyCommonBVO.getCURR_TOTAL_PAGE());
		P10ResultDataVO.setCurr_total_rec(txRespBodyCommonBVO.getCURR_TOTAL_REC());
		P10ResultDataVO.setTotal_page(txRespBodyCommonBVO.getTOTAL_PAGE());
		P10ResultDataVO.setTotal_rec(txRespBodyCommonBVO.getTOTAL_REC());
		P10ResultDataVO.setResult_data(resolveP10TxRespEntity(txRespVO.getTxRespBody().getTxRespBodyEntity()));
		
		result.setResult(P10ResultDataVO);
		
		return result;
	}


	/**
	 * 	解析P10接口响应体
	 * 
	 * @param txRespBodyEntity
	 * @return
	 */
	private List<Map<String, Object>> resolveP10TxRespEntity(TxRespBodyEntityVO txRespBodyEntity) {
		// 返回结果
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		
		if(txRespBodyEntity.getENQR_RST_GRP() == null || txRespBodyEntity.getENQR_RST_GRP().size() == 0) {
			return list;
		}
		
		// 结果集 字段
		String[] mapKeys = txRespBodyEntity.getRet_Col_Set_Inf().split(",");
		//List<String> mapEntryKeys = new ArrayList<String>();
		//Collections.addAll(mapEntryKeys, mapEntryKeysArray);
		
		for(TxEnqrRstVO txEnqrRst : txRespBodyEntity.getENQR_RST_GRP()) {
			// txEnqrRsts mapKeys 两者的元素数量应该一致
			String[] txEnqrRsts = txEnqrRst.getEnqr_RstInf().split("|@|");
			
			Map<String, Object> map = new HashMap<String, Object>(mapKeys.length);
			for(int index = 0; index < mapKeys.length; index ++) {
				map.put(mapKeys[index], txEnqrRsts[index]);
			}
			
			list.add(map);
		}
		
		return list;
	}


	/**
	 * 构造 P10 接口xml 报文
	 * @param req
	 * @return
	 */
	private String createP10ReqXml(P10ReqVO req) {
		// 实例化
		TxReqVO txReqVO = new TxReqVO();
		TxReqHeadVO txReqHeadVO = new TxReqHeadVO();
		TxReqBodyVO txReqBodyVO = new TxReqBodyVO();
		TxReqBodyEntityVO txReqBodyEntityVO = new TxReqBodyEntityVO();
		TxReqBodyCommonVO txReqBodyCommonVO = new TxReqBodyCommonVO();
		TxReqBodyCommon7VO txReqBodyCommon7VO = new TxReqBodyCommon7VO();
		TxReqBodyCommon4VO txReqBodyCommon4VO = new TxReqBodyCommon4VO();
		TxReqBodyCommon1VO txReqBodyCommon1VO = new TxReqBodyCommon1VO();
		
		// TODO 根据请求设置值
		txReqHeadVO.setSYS_HDR_LEN("0");
		txReqHeadVO.setSYS_PKG_VRSN("01");
		txReqHeadVO.setSYS_TTL_LEN("0");
		txReqHeadVO.setSYS_REQ_SEC_ID("110013");
		txReqHeadVO.setSYS_SND_SEC_ID("644012");
		txReqHeadVO.setSYS_TX_CODE("A0831D023");
		txReqHeadVO.setSYS_TX_VRSN("01");
		txReqHeadVO.setSYS_TX_TYPE("720000");
		txReqHeadVO.setSYS_EVT_TRACE_ID(req.getEvtTraceId()); // 全局事件跟踪号 25位
		txReqHeadVO.setSYS_SND_SERIAL_NO("0000000000");
		txReqHeadVO.setSYS_PKG_TYPE("1");
		txReqHeadVO.setSYS_MSG_LEN("0000003210");
		txReqHeadVO.setSYS_IS_ENCRYPTED("0");
		txReqHeadVO.setSYS_ENCRYPT_TYPE("3");
		txReqHeadVO.setSYS_COMPRESS_TYPE("0");
		txReqHeadVO.setSYS_EMB_MSG_LEN("0");
		txReqHeadVO.setSYS_REQ_TIME(DateUtil.dateToString(req.getReqTime(), "yyyyMMddHHmmssSSS")); // 请求时间 yyyyMMddHHmmssSSS，取当前时间？
		txReqHeadVO.setSYS_TIME_LEFT("110001015");
		txReqHeadVO.setSYS_PKG_STS_TYPE("00");
		
		txReqBodyCommon1VO.setTXN_INSID("440000000");
		txReqBodyCommon1VO.setTXN_ITT_CHNL_ID("999999999");
		txReqBodyCommon1VO.setTXN_ITT_CHNL_CGY_CODE("99999999");
		txReqBodyCommon1VO.setTXN_DT(DateUtil.dateToString(req.getReqTime(), "yyyyMMdd")); // 请求时间 yyyyMMdd
		txReqBodyCommon1VO.setTXN_TM(DateUtil.dateToString(req.getReqTime(), " HHmmss")); // 请求时间 HHmmss
		txReqBodyCommon1VO.setTXN_STFF_ID("99999999");
		txReqBodyCommon1VO.setMULTI_TENANCY_ID("zh-cn");
		txReqBodyCommon1VO.setBSN_MT_ENT_IDR("1");
		
		txReqBodyCommon4VO.setPAGE_JUMP(req.getReq_params().getPage_jump()); // 第几页
		txReqBodyCommon4VO.setREC_IN_PAGE(req.getReq_params().getRec_in_page()); // 每页记录数量
		
		txReqBodyCommon7VO.setCALL_PRTY_LGC_SBM_ID("A0622");
		txReqBodyCommon7VO.setCALL_PRTY_SVC_ID("A0622K001");
		txReqBodyCommon7VO.setCALL_PRTY_TXNSRLNO(req.getEvtTraceId()); // 调用方交易流水号 （这里使用 全局事件跟踪号）
		
		txReqBodyEntityVO.setCmpt_ID("A0831_CCBD_DS");
		txReqBodyEntityVO.setSvc_ID(P10SvcConfig.getInstance().getSvcIdMap().get(req.getItf_no())); // 转换为P10服务ID
		txReqBodyEntityVO.setBsn_Parm_Fld_Nm(getQueryFldNms(req.getItf_no())); // 需要查询的列，根据 接口编号判断哪个表的所有字段
		txReqBodyEntityVO.setEnqr_Cnd_Cntnt(getQueryCnd(req.getReq_params())); // 查询条件，解析、拼接请求中的 params orderby
		
		// 组装
		txReqBodyCommonVO.setTxReqBodyCommon1(txReqBodyCommon1VO);
		txReqBodyCommonVO.setTxReqBodyCommon4(txReqBodyCommon4VO);
		txReqBodyCommonVO.setTxReqBodyCommon7(txReqBodyCommon7VO);
		txReqBodyVO.setTxReqBodyCommon(txReqBodyCommonVO);
		txReqBodyVO.setTxReqBodyEntity(txReqBodyEntityVO);
		txReqVO.setTxReqBody(txReqBodyVO);
		txReqVO.setTxReqHead(txReqHeadVO);
		
		// 转为xml
		String xml = XstreamUtil.beanToXml(txReqVO, AppConfig.A0831D023_ENCODING);
		String reqXml = "<?xml version=\"1.0\" encoding=\""+ AppConfig.A0831D023_ENCODING + "\"?>\n" + xml;
		
		return reqXml;
	}


	/**
	 * 	拼接sql查询条件 
	 * 		过滤条件（不可为空）
	 * 		排序条件（可为空）
	 * 
	 * @param req_params
	 * @return
	 */
	private String getQueryCnd(P10ReqParamVO req_params) {
		String cnd = "";
		Map<String, String> filterParams = req_params.getParams();
		if(filterParams == null || filterParams.size() == 0) {
			log.warn("过滤条件为空");
			// 只返回排序条件
			String orderby = req_params.getOrderby();
			if(StringUtils.isBlank(orderby)) {
				// orderby 也是空
				cnd = "";
			} else {
				cnd = " order by " + orderby;
			}
			return cnd;
		}
		
		// 如果过滤条件不为空
		StringBuffer whereSb = new StringBuffer();
		String whereStr = "";
		Set<Map.Entry<String, String>> filterParamEntrySet = filterParams.entrySet();
		
		for(Map.Entry<String, String> entry : filterParamEntrySet) {
			// TODO 支持日期区间、数值区间、数字全等、字符串全等 （多个条件逻辑关系为 and）
			// 暂时支支持 字符串全等
			whereSb.append(entry.getKey()).append("=").append(entry.getValue()).append(" and ");
		}
		
		// 如果有多个条件，则去掉最后一个 and 
		int lastIndex = whereSb.lastIndexOf(" and ");
		if(lastIndex != -1) {
			whereStr = whereSb.substring(0, lastIndex);
		} else {
			whereStr = whereSb.toString();
		}
		// orderby
		String orderby = req_params.getOrderby();
		if(StringUtils.isBlank(orderby)) {
			// 没有orderby
			cnd = whereStr;
		} else {
			cnd = whereStr + " order by " + orderby;
		}
		
		return cnd;
	}


	/**
	 * 	获取查询的字段名
	 * @param itf_no	接口编号 如 10000
	 * @return
	 */
	private String getQueryFldNms(String itf_no) {
		// 根据接口编号从map中获取 查询的字段名 字符串
		
		// TODO 暂时手动 <![CDATA[]]
		return P10SvcConfig.getInstance().getSvcIdFldNmsMap().get(itf_no);
	}
	
	
}
