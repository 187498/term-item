package com.scu03.bean;
import java.util.List;
public class PageBean<T> {
	private int pageNum;  // 当前选择的页数
	private int pageSize;  //每页显示的数据数目
	private int totalRecord;
	
	private int totalPage;
	private int startIndex;
	
	private List<T> list;
	
	private int start;
	private int end;
	
	public PageBean(int pageNum,int pageSize,int totalRecord){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		if(totalRecord%pageSize == 0){
			this.totalPage = totalRecord/pageSize; //没有多余页
		}else{
			this.totalPage = totalRecord/pageSize + 1; //多一页显示多余数据
		}
		
		//索引
		this.startIndex = (pageNum-1)*pageSize;
		
		//最多一次显示页数
		this.start = 1;
		this.end = 5;
		//
		
		if(totalPage <= 5){
			//需要的页数小于5,最大页数为当前页数的值
			this.end = this.totalPage;
			//无记录
			if(end == 0){
				start = 0;
			}
		}else{
			this.start = pageNum - 2;
			this.end = pageNum + 2;
			if(start <= 0 ){
				this.start = 1;
				this.end = 5;
				
			}
			if(end >this.totalPage){
				//当前页+2 比最大页数大
				this.end = totalPage;
				this.start = end - 5;
			}
		}	
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	//
	public List<T> getList(){
		return list;
	}
	
	public void setList(List<T> list){
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	

}
