package com.scu03.bean;
import java.util.List;
public class PageBean<T> {
	private int pageNum;  // ��ǰѡ���ҳ��
	private int pageSize;  //ÿҳ��ʾ��������Ŀ
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
			this.totalPage = totalRecord/pageSize; //û�ж���ҳ
		}else{
			this.totalPage = totalRecord/pageSize + 1; //��һҳ��ʾ��������
		}
		
		//����
		this.startIndex = (pageNum-1)*pageSize;
		
		//���һ����ʾҳ��
		this.start = 1;
		this.end = 5;
		//
		
		if(totalPage <= 5){
			//��Ҫ��ҳ��С��5,���ҳ��Ϊ��ǰҳ����ֵ
			this.end = this.totalPage;
			//�޼�¼
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
				//��ǰҳ+2 �����ҳ����
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
