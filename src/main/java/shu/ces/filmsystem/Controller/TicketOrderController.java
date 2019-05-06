package shu.ces.filmsystem.Controller;

import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.BO.BookingRecordBO;
import shu.ces.filmsystem.BO.TicketOrderBO;
import shu.ces.filmsystem.Model.BookingRecord;

public class TicketOrderController {
    @PostMapping("/ticket/createOrder")
    public boolean createBookingRecord(@RequestParam("userId") Integer userId,
                                       @RequestParam("showId") Integer showId,
                                       @RequestParam("row") Integer row,
                                       @RequestParam("col") Integer col){
        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
        try{
            BookingRecord record = new BookingRecord();
            record.setUserId(userId);
            record.setShowId(showId);
            record.setRow(row);
            record.setCol(col);
            return new TicketOrderBO().createOrder(record);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/ticket/payOrder")
    public String payOrder(@RequestParam("id") Integer id){
        /**
         * @return: collect string or null
         */
        TicketOrderBO orderBO = new TicketOrderBO();
        BookingRecord record = new BookingRecordBO().findOrderById(id);
        if(orderBO.payOrder(record)){
            return orderBO.getCollectString(record);
        }
        return null;
    }

    @GetMapping("/ticket/collectString")
    public String getCollectString(@RequestParam("id") Integer id){
        /**
         * @return: collect string or null
         */
        BookingRecord record = new BookingRecordBO().findOrderById(id);
        return record != null ? record.getCollectingString() : null;
    }

    @PutMapping("/ticket/cancelOrder")
    public boolean cancelOrder(@RequestParam("id") Integer id){
        BookingRecord record = new BookingRecordBO().findOrderById(id);
        if(record != null){
            return new TicketOrderBO().cancelOrder(record);
        }
        return false;
    }
}
