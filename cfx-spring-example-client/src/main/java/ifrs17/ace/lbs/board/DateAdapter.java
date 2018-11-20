package ifrs17.ace.lbs.board;

import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import framexpert.run.common.util.date.DateUtil;

public class DateAdapter extends XmlAdapter<String, Timestamp> {

    private String dateFormat = "yyyy-MM-dd HH:mm:ss.S";

    @Override
    public String marshal(Timestamp v) throws Exception {
        return DateUtil.formatDate(v.getTime(), dateFormat);
    }

    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return new Timestamp(DateUtil.toDate(v, dateFormat).getTime());
    }

}