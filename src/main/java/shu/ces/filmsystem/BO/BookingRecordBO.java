package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.BookingRecord;

import java.util.ArrayList;

public class BookingRecordBO {
    public ArrayList<BookingRecord> findOrderByUserId(int userId){
        ArrayList<BookingRecord> list = new ArrayList<>();
        // find in database
        return list;
    }

    public BookingRecord findOrderById(int id){
        // find in database
        return null;
    }

    public boolean deleteOrder(int id){
        BookingRecord record = new BookingRecord(); // find in database
        return deleteOrder(record);
    }

    public boolean deleteOrder(BookingRecord record){
        if(record.getStatus() == 1 || record.getStatus() == 2){    // 只有取消或已出票的订单才可删除
            return false;
        }
        record.setStatus(-1);           // 修改订单状态为已取消
        // delete in database
        return true;
    }
}
