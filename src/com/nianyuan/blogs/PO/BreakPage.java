package com.nianyuan.blogs.PO;

public class BreakPage {

	private int start;		// 起始位置
	private int pageSize=3; // 页面大小
	private int end;		// 终止位置
	private int currentPage;// 当前页
	private int totalPage;	// 总页数

	public BreakPage(int _total ){
		
		start = 1;
		currentPage=1;
		end = currentPage*pageSize;
		totalPage =_total/pageSize;
		if( (_total%pageSize) != 0)
		{
			totalPage++;
		}		
	}
	public int getCurrentPage(){
		
		return currentPage;
	}
	public int getTotalPage(){
		
		return totalPage;
	}
	
	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
	// 下一页
	public void downPage(int _currentPage){
		
		currentPage = _currentPage;
		if(currentPage >= totalPage){
			
			currentPage=_currentPage-1;
		}
		currentPage++;
		start=(currentPage-1)*pageSize+1;
		end =start+pageSize-1;
	}
	// 上一页
	public void upPage(int _currentPage){
		
		currentPage = _currentPage;
		if(currentPage <= 1){
			
			currentPage=_currentPage+1;
		}
		currentPage--;
		start=(currentPage-1)*pageSize+1;
		end =start+pageSize-1;
	}
	// 首页
	public void firstPage(){
		
		currentPage=1;
		start=(currentPage-1)*pageSize+1;
		end =start+pageSize-1;
	}
	// 尾页
	public void endPage(){
		
		currentPage=totalPage;
		start=(currentPage-1)*pageSize+1;
		end =start+pageSize-1;
	}
}
