package diquest.click.apps;

public class Page {
	
	private int page; //조회 페이지
    private int indexSize; //노출 될 최대 페이지 링크 수 
    private int lastPage; //조회 가능한 마지막 페이지 
    private int pageSize; //페이지당 로우 수
    private int totalRows; //조회된 전체 로우 수
    private boolean nextPage; //다음페이지가 있는지 여부
    private boolean prevPage; //이전페이지가 있는지 여부
    private int beginNavigationPage; //시작페이지 next
    private int endNavigationPage;  //마지막페이지
    private String gubun;  
    private String logtype;  
    private String counting;  
    private String rownum;  

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isPrevPage() {
		return prevPage;
	}

	public void setPrevPage(boolean prevPage) {
		this.prevPage = prevPage;
	}

	public int getBeginNavigationPage() {
		return beginNavigationPage;
	}

	public void setBeginNavigationPage(int beginNavigationPage) {
		this.beginNavigationPage = beginNavigationPage;
	}

	public int getEndNavigationPage() {
		return endNavigationPage;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getCounting() {
		return counting;
	}

	public void setCounting(String counting) {
		this.counting = counting;
	}

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public void setEndNavigationPage(int endNavigationPage) {
		this.endNavigationPage = endNavigationPage;
	}
	
    /**
     * 페이징 관련 변수 초기화<br/>
     * 한 페이지당 보여줄 Row 수 pageSize = 10<br/>
     * 한 화면에서 페이징 가능한 수 indexSize = 10<br/>
     */
    public Page() {
        //set default value
        setIndexSize(10);
        setPageSize(10);
    }
    
    /**
     * 페이징 관련 변수 초기 화 <br/>
     * 입력 받은 페이징 수 대로 초기화 한다. <br/>
     * @param pageSize
     * @param indexSize
     */
    public Page(int pageSize,int indexSize) {
        //set default value
        setPage(1);
        setIndexSize(indexSize);
        setPageSize(pageSize);
    }

	/**
     * <pre>
     * 끝나는 페이지 번호 
     * </pre>
     *
     * @return int 
     */
    public int getRowTo() {
        return getPage() * getPageSize();
    }

    /**
     * <pre>
     * 시작하는 페이지 번호 
     * </pre>
     *
     * @return int 
     */
    public int getRowFrom() {
        return (getPage() - 1) * getPageSize() + 1;
    }

    /**
     * <pre>
     * 페이지 번호를 리턴한다.
     * </pre>
     *
     * @return int 
     */
    public int getPage() {
        if (page <= 0)
            page = 1;
        return page;
    }

    /**
     * <pre>
     * page 를 셋팅한다.
     * </pre>
     *
     * @param page
     */
    public void setPage(int page) {
        if (page <= 0)
            page = 1;
        this.page = page;

    }
    /**
     * <pre>
     * lastPage 를 셋팅한다.
     * </pre>
     *
     * @return int 
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * <pre>
     * int 을 반환하는 기능을 제공한다.
     * </pre>
     *
     * @param lastPage
     */
    public void setLastPage(int lastPage) {
        if (lastPage < page)
            setPage(1);

        this.lastPage = lastPage;
    }


    /**
     * <pre>
     * totalRows 를 셋팅한다.
     * </pre>
     *
     * @param totalRows
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;

        int lastPage = (getTotalRows() - 1) / getPageSize() + 1;
        //System.out.println(lastPage);
        setLastPage(lastPage);
        setBeginNavigationPage(((getPage() - 1) / getIndexSize()) * getIndexSize() + 1);
        setEndNavigationPage(Math.min((beginNavigationPage + getIndexSize() - 1), getLastPage()));
        
        setNextPage(getLastPage() > endNavigationPage ? true : false);
        setPrevPage(beginNavigationPage > 1 ? true : false);
    }

    /**
     * <pre>
     * int 을 반환하는 기능을 제공한다.
     * </pre>
     *
     * @return int
     */
    public int getIndexSize() {
        return indexSize;
    }

    /**
     * <pre>
     * indexSize 을 설정하는 기능을 제공한다.
     * </pre>
     *
     * @param indexSize int
     */
    public void setIndexSize(int indexSize) {
        this.indexSize = indexSize;
    }

    /**
     * <pre>
     * int 을 반환하는 기능을 제공한다.
     * </pre>
     *
     * @return int
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * <pre>
     * int 을 반환하는 기능을 제공한다.
     * </pre>
     *
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * <pre>
     * pageSize 을 설정하는 기능을 제공한다.
     * </pre>
     *
     * @param pageSize int
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * <pre>
     * 페이징 네비게이터 바를 만들어 리턴한다. 
     * </pre>
     *
     * @see java.lang.Object#toString()
     *
     * @return String 
     *
     */
    
    public String toString() {
        StringBuffer navigator = new StringBuffer();
        navigator.append("<div class=\"paging clear2 mt_25\">");
        if (getLastPage() > 1) {
            
        	int beginNavigationPage = ((getPage() - 1) / getIndexSize()) * getIndexSize() + 1;
            int endNavigationPage = Math.min((beginNavigationPage + getIndexSize() - 1), getLastPage());
            boolean needPrevLink = beginNavigationPage > 1 ? true : false;
            boolean needNextLink = getLastPage() > endNavigationPage ? true : false;

            navigator.append(" ");
            if( needPrevLink ) {// 이전 페이지 존재 
                int prevPage = ( (getPage()-1)/getIndexSize() ) * getIndexSize(); 
				/*
				 * navigator.append("<span class=\"btn_page first\"><a title=\"처음\" href=\"");
				 */
                navigator.append("<span class=\"btn_page first\"><a title=\"처음\" href=\"#\" onclick=\"MovingPage('1','"+getGubun()+"','"+getLogtype()+"','"+getCounting()+"')\"></a></span>");
                navigator.append("<span class=\"btn_page prev\"><a title=\"이전\" href=\"#\" onclick=\"MovingPage('"+(getBeginNavigationPage()-1)+"','"+getGubun()+"','"+getLogtype()+"','"+getCounting()+"')\"></a></span>");
                /*navigator.append("<a class=\"prev\" href=\"#\" onclick=\"searchdo('" + prevPage + "')\">이전</a>");*/
                
                //preradio postradio checkParam
            } 
            navigator.append(" ");
            //현재 페이지 번호가 포함되는 링크 index 영역을 구한다.
            //마지막 페이지 보다 index의 end가 크다면 index의 end는 마지막 페이지
            //구해진 index 영역 만큼 돌리며 link decoration한다.
            for (int i = beginNavigationPage; i <= endNavigationPage; i++) {
                if (getPage() == i) {
                    //navigator.append("<a href=\"#\">" + i + "</a>&nbsp;");
                    navigator.append("<span class=\"on\">"+i+"</a></span>");
                } else {
                	navigator.append("<span><a href=\"#\" onclick=\"MovingPage('"+i+"','"+getGubun()+"','"+getLogtype()+"','"+getCounting()+"')\">"+i+"</a></span>");
                }
            }
            navigator.append(" ");

            if( needNextLink ) { // 다음 페이지 존재
                int nextPage = ( (getPage()-1)/getIndexSize() + 1 ) * getIndexSize() + 1; 
                
                navigator.append("<span class=\"btn_page next\"><a title=\"다음\" href=\"#\" onclick=\"MovingPage('"+(getEndNavigationPage()+1)+"','"+getGubun()+"','"+getLogtype()+"','"+getCounting()+"')\"></a></span>");
                navigator.append("<span class=\"btn_page last\"><a title=\"마지막\" href=\"#\" onclick=\"MovingPage('"+getLastPage()+"','"+getGubun()+"','"+getLogtype()+"','"+getCounting()+"')\"></a></span>");
                navigator.append("</div>");
            } else {

            }
        }else{
        	navigator.append("<a href=\"#search\" class=\"active\">1</a>&nbsp");
        }
        return navigator.toString();
    }

}
