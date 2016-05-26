package com.ffcs.crmd.platform.data.ddl;

import java.util.ArrayList;
import java.util.List;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.ddl.api.DdlConstants;
import com.ffcs.crmd.platform.ddl.api.ICrmSeqService;

public class SeqServiceFactory {
	private static ICrmSeqService emptySeqService = new ICrmSeqService() {

		@Override
		public List<Long> getSeqBatch(String seqName, int size) {
			return new ArrayList<Long>();
		}

		@Override
		public Long getSeq(String seqName) {
			return Long.MIN_VALUE;
		}
	};

	public static ICrmSeqService getSeqService() {
		if (ApplicationContextUtil.containsBean(DdlConstants.SEQ_SERVICE)) {
			return ApplicationContextUtil.getBean(DdlConstants.SEQ_SERVICE);
		} else if (ApplicationContextUtil.containsBean(DdlConstants.DEFAULT_SEQ_SERVICE)) {
			return ApplicationContextUtil.getBean(DdlConstants.DEFAULT_SEQ_SERVICE);
		} else {
			return emptySeqService;
		}
	}

}
