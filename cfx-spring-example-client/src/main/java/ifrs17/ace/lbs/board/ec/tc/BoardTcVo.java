package ifrs17.ace.lbs.board.ec.tc;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import framexpert.run.common.io.type.annotation.CompositeType;
import framexpert.run.common.io.type.annotation.Property;
import framexpert.run.oltp.ext.annotation.LocalName;
import framexpert.run.oltp.ext.annotation.TableVo;
import framexpert.run.oltp.ext.vo.AbstractVo;


/**
 * 게시판
 *
 * <pre>
 * 게시판관리
 * </pre>
 *
 * @author shkwon
 * @version 1.0
 * @since 2018.07.17 신규작성
 */
@TableVo
@CompositeType
@LocalName("게시판")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardTcVo extends AbstractVo {

	private static final long serialVersionUID = 1L;

	@Property(length=20)
    private BigDecimal id;

	@Property(length=10)
    private String boardType;

	@Property(length=200)
    private String subject;

	@Property(length=500)
    private String contents;

	@Property(length=20)
    private BigDecimal hit;

	@Property(length=100)
    private String regId;

	@Property(length=17)
	@XmlJavaTypeAdapter(value=framexpert.run.common.util.xml.support.TimestampXmlAdapter.class)
    private Timestamp regDate;

	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id){
		this.id = id;
	}
	
	public String getBoardType() {
		return boardType;
	}
	
	public void setBoardType(String boardType){
		this.boardType = boardType;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents){
		this.contents = contents;
	}
	
	public BigDecimal getHit() {
		return hit;
	}
	
	public void setHit(BigDecimal hit){
		this.hit = hit;
	}
	
	public String getRegId() {
		return regId;
	}
	
	public void setRegId(String regId){
		this.regId = regId;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Timestamp regDate){
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BoardTcVo [" + "id=" + id + ", boardType=" + boardType + ", subject=" + subject + ", contents=" + contents + ", hit=" + hit + ", regId=" + regId + ", regDate=" + regDate + "]";
	}
}