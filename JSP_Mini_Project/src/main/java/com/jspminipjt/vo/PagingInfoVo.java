package com.jspminipjt.vo;

public class PagingInfoVo {
	private int totalPostCnt; // 전체 게시판 글의 갯수
	private int pagePostCnt = 10; // 한페이지에 보여줄 글의 갯수
	private int totalPageCnt; // 총페이지 수
	private int startRowIndex; // 보여주기 시작할 글의 row index 번호
	private int pageNo; // 유저가 클릭한 페이지의 번호
	
	private int pageBlockCnt = 5; // 한개 블럭에 보여줄 페이지 갯수
	private int totalPagingBlock; // 전체 페이징 블럭 객수
	private int currentPageBlock; // 현재 페이지가 속한 페이징 블럭 번호
	private int startPageNum; // 현재 블럭의 시작 페이지 번호
	private int endPageNum; // 현재 블럭의 마지막 페이지 번호
	
	
	public PagingInfoVo() {
		super();
	}

	public int getTotalPostCnt() {
		return totalPostCnt;
	}
	
	public int getPagePostCnt() {
		return pagePostCnt;
	}
	
	public int getTotalPageCnt() {
		return totalPageCnt;
	}
	
	public int getStartRowIndex() {
		return startRowIndex;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setTotalPostCnt(int totalPostCnt) {
		this.totalPostCnt = totalPostCnt;
	}

	public void setPagePostCnt(int pagePostCnt) {
		this.pagePostCnt = pagePostCnt;
	}

	public void setTotalPageCnt(int totalPostCnt, int pagePostCnt) {
		if ( totalPostCnt % pagePostCnt == 0) {
			this.totalPageCnt = totalPostCnt / pagePostCnt;			
		} else {
			this.totalPageCnt = totalPostCnt / pagePostCnt + 1;						
		}
		
//		Math.ceil(totalPostCnt / pagePostCnt);
	}
	
	public void setTotalPageCnt() {
//		if ( totalPostCnt % pagePostCnt == 0) {
//			this.totalPageCnt = totalPostCnt / pagePostCnt;			
//		} else {
//			this.totalPageCnt = totalPostCnt / pagePostCnt + 1;						
//		}
		
		Math.ceil(this.totalPostCnt / this.pagePostCnt);
	}

	public void setStartRowIndex() {
		this.startRowIndex = (this.pageNo - 1) * this.pagePostCnt;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	
	
	
	
	
	public int getPageBlockCnt() {
		return pageBlockCnt;
	}

	public int getTotalPagingBlock() {
		return totalPagingBlock;
	}

	public int getCurrentPageBlock() {
		return currentPageBlock;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}
	

	public void setPageBlockCnt(int pageBlockCnt) {
		this.pageBlockCnt = pageBlockCnt;
	}

	public void setTotalPagingBlock() {
		if (this.totalPageCnt % this.pageBlockCnt  == 0) {
			this.totalPagingBlock = totalPageCnt / pageBlockCnt ;
		} else {
			this.totalPagingBlock = totalPageCnt / pageBlockCnt + 1;
		}
	}

	public void setCurrentPageBlock() {
		if (this.pageNo % this.pageBlockCnt == 0) {
			this.currentPageBlock = this.pageNo / this.pageBlockCnt ;			
		} else {
			this.currentPageBlock = (int)Math.ceil((double)this.pageNo / this.pageBlockCnt);						
//			this.currentPageBlock = this.pageNo / this.pageBlockCnt + 1;						
		}
	}

	public void setStartPageNum() {
		this.startPageNum = (this.currentPageBlock - 1) * this.pageBlockCnt + 1;
	}

	public void setEndPageNum() {
		this.endPageNum = this.currentPageBlock * this.pageBlockCnt;			
		if (this.endPageNum > this.totalPageCnt) {
			this.endPageNum = this.totalPageCnt;						
		}
	}

	@Override
	public String toString() {
		return "PagingInfoVo [totalPostCnt=" + totalPostCnt + ", pagePostCnt=" + pagePostCnt + ", totalPageCnt="
				+ totalPageCnt + ", startRowIndex=" + startRowIndex + ", pageNo=" + pageNo + ", pageBlockCnt="
				+ pageBlockCnt + ", totalPagingBlock=" + totalPagingBlock + ", currentPageBlock=" + currentPageBlock
				+ ", startPageNum=" + startPageNum + ", endPageNum=" + endPageNum + "]";
	}



}
