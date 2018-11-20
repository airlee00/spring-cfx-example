package ifrs17.ace.lbs.board.bc;

import java.util.List;

import javax.jws.WebService;

import framexpert.run.oltp.ext.vo.SimpleResultVo;
import ifrs17.ace.lbs.board.bc.vo.BoardInPageVo;
import ifrs17.ace.lbs.board.bc.vo.BoardOutPageVo;
import ifrs17.ace.lbs.board.ec.tc.BoardTcVo;

/**
 * 게시판관리
 * 
 * <pre>
 * 게시판 등록,수정,삭제
 * </pre>
 * @author shkwon
 * @version 1.0
 * @since 2018.07.17 신규작성
 */
@WebService
public interface BoardBc {
    
    public BoardOutPageVo getBoardList(BoardInPageVo boardInPageVo);
    
    public SimpleResultVo insertBoard(BoardTcVo boardTcVo);
    
    public SimpleResultVo updateBoard(BoardTcVo boardTcVo);
    
    public SimpleResultVo deleteBoard(BoardTcVo boardTcVo);
    
}