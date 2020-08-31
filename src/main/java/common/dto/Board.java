package common.dto;

/**
 * 파일 업로드를 하는 게시판들의 정보를 저장해놓은 테이블 
 */
public class Board {

	// member field
	private int boardNo;
	private String boardName;
	
	// toString()
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardName=" + boardName + "]";
	}

	// getter(), setter()
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
