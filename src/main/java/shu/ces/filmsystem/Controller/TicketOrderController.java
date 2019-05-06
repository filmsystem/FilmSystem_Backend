package shu.ces.filmsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.BookingRecordBO;
import shu.ces.filmsystem.BO.TicketOrderBO;
import shu.ces.filmsystem.Model.BookingRecord;

public class TicketOrderController {
    @PostMapping("/bookingticket/createorder")
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

    @PutMapping("/bookingticket/payorder")
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

    @GetMapping("/bookingticket/collectstring")
    public String getCollectString(@RequestParam("id") Integer id){
        /**
         * @return: collect string or null
         */
        BookingRecord record = new BookingRecordBO().findOrderById(id);
        return record != null ? record.getCollectingString() : null;
    }
}
