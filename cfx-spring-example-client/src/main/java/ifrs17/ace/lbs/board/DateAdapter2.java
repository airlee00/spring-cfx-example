package ifrs17.ace.lbs.board;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter2 extends XmlAdapter<Timestamp, Timestamp> {

    private String dateFormat = "yyyy-MM-dd HH:mm:ss.S";

    @Override
    public Timestamp marshal(Timestamp v) throws Exception {
        System.out.println("------------------------111111111111111111111111111");
        return v;//new Date(v.getTime());//DateUtil.formatDate(v.getTime(), dateFormat);
    }

    @Override
    public Timestamp unmarshal(Timestamp v) throws Exception {
        System.out.println("------------------------2222222222222222");
        return v;//new Timestamp(v.getTime());//DateUtil.toDate(v, dateFormat).getTime());
    }

}