package ifrs17.ace.lbs.board.bc.vo;

import framexpert.run.common.io.type.annotation.Property;
import framexpert.run.oltp.ext.vo.AbstractVo;
import framexpert.run.oltp.ext.vo.PageVo;

/**
 * 게시판 페이징 조회
 *
 * <pre>
 * 게시판 페이징 조회
 * </pre>
 *
 * @author shkwon
 * @version 1.0
 * @since 2018.07.17 신규작성
 * @since 2018.08.24 shkwon 최종수정
 */
public class BoardInPageVo extends AbstractVo {

	private static final long serialVersionUID = 1L;

	@Property(typeName="게시판유형", length=20)
    private String boardType;

	@Property(typeName="페이지처리용  vo")
    private PageVo pageVo;

	public String getBoardType() {
		return boardType;
	}
	
	public void setBoardType(String boardType){
		this.boardType = boardType;
	}
	
	public PageVo getPageVo() {
		return pageVo;
	}
	
	public void setPageVo(PageVo pageVo){
		this.pageVo = pageVo;
	}
	
	@Override
	public String toString() {
		return "BoardInPageVo [" + "boardType=" + boardType + ", pageVo=" + pageVo + "]";
	}
}