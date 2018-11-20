package ifrs17.ace.lbs.board.bc.vo;

import java.util.List;

import framexpert.run.common.io.type.annotation.Property;
import framexpert.run.oltp.ext.vo.AbstractVo;
import framexpert.run.oltp.ext.vo.PageVo;
import ifrs17.ace.lbs.board.ec.tc.BoardTcVo;

/**
 * 게시판응답
 *
 * <pre>
 * 게시판응답
 * </pre>
 *
 * @author kclee
 * @version 1.0
 * @since 2018.09.21 신규작성
 * @since 2018.09.21 kclee 최종수정
 */
public class BoardOutPageVo extends AbstractVo {

	private static final long serialVersionUID = 1L;

	@Property(typeName="게시판", maxSize={10})
    private List<BoardTcVo> boardList;

	@Property(typeName="페이지처리용  vo")
    private PageVo pageVo;

	public List<BoardTcVo> getBoardList() {
		return boardList;
	}
	
	public void setBoardList(List<BoardTcVo> boardList){
		this.boardList = boardList;
	}
	
	public PageVo getPageVo() {
		return pageVo;
	}
	
	public void setPageVo(PageVo pageVo){
		this.pageVo = pageVo;
	}
	
	@Override
	public String toString() {
		return "BoardOutPageVoVo [" + "boardList=" + boardList + ", pageVo=" + pageVo + "]";
	}
}