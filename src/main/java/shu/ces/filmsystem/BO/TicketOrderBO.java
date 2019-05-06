package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.BookingRecord;
import shu.ces.filmsystem.Tools.RandomString;

import java.sql.Timestamp;
import java.util.ArrayList;

public class TicketOrderBO {
    public boolean createOrder(BookingRecord record){
        record.setStatus(1);
        record.setCreateTime(new Timestamp(System.currentTimeMillis()));
        // insert in database
        // update seat
        return true;
    }

    public boolean payOrder(BookingRecord record){
        if(record.getStatus() != 1){    // 订单不是待支付状态
            return false;
        }
        record.setStatus(2);            // 修改订单为已支付状态
        record.setPayTime(new Timestamp(System.currentTimeMillis()));
        // update in database
        return true;
    }

    public String getCollectString(BookingRecord record){
        if(record.getStatus() != 2){    // 订单不是已支付状态
            return null;
        }
        record.setStatus(3);            // 修改订单为已出票状态
        String randomStr = randomString();
        record.setCollectingString(randomStr);

        // update in database
        return randomStr;
    }

    public boolean cancelOrder(BookingRecord record){
        if(record.getStatus() == 3){    // 订单出票则不可取消
            return false;
        }
        record.setStatus(-1);           // 修改订单状态为已取消
        // update in database
        return true;
    }

    private String randomString(){
        return RandomString.getRandomString(16);
    }
}
