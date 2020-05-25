package diquest.click.apps;

public class DeadLink {
	private String title;
	private String content;
	private String ROWNUMC;
	private String MAINSEQ;
	private String URL;
	private String CATEGORY_NAME;
	private String BBS_NAME;
	private int currentPage;
	private int firstPage;
	private int LastPage;
	

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return LastPage;
	}
	public void setLastPage(int lastPage) {
		LastPage = lastPage;
	}
	public String getROWNUMC() {
		return ROWNUMC;
	}
	public void setROWNUMC(String rOWNUMC) {
		ROWNUMC = rOWNUMC;
	}
	public String getMAINSEQ() {
		return MAINSEQ;
	}
	public void setMAINSEQ(String mAINSEQ) {
		MAINSEQ = mAINSEQ;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	public String getBBS_NAME() {
		return BBS_NAME;
	}
	public void setBBS_NAME(String bBS_NAME) {
		BBS_NAME = bBS_NAME;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "DeadLink [title=" + title + ", content=" + content + ", currentPage=" + currentPage + "]";
	}


}
