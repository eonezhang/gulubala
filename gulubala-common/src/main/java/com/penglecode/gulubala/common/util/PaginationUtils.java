package com.penglecode.gulubala.common.util;

import java.util.ArrayList;
import java.util.List;

import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;

/**
 * 分页工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月18日 下午4:48:17
 * @version 1.0
 */
public class PaginationUtils {

	/**
	 * 内存分页方法
	 * @param allDataList
	 * @param pager
	 * @return
	 */
	public static <T> PagingList<T> getPagingList(List<T> allDataList, Pager pager) {
		int totalRowCount = 0;
		List<T> dataList = new ArrayList<T>();
		if(!CollectionUtils.isEmpty(allDataList)){
			totalRowCount = allDataList.size();
			int start = (pager.getCurrentPage() - 1) * pager.getPageSize();
			int end = pager.getCurrentPage() * pager.getPageSize();
			if(totalRowCount > start){
				end = totalRowCount > end ? end : totalRowCount;
				for(int i = start; i < end; i++){
					dataList.add(allDataList.get(i));
				}
			}
		}
		pager.setTotalRowCount(totalRowCount);
		return new PagingList<T>(dataList, pager);
	}
	
}
