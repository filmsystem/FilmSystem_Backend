package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.TicketOrderBO;
import shu.ces.filmsystem.Model.BookingRecord;

public class BookingRecordController {
    public static Logger log = LoggerFactory.getLogger(FilmShowController.class);

    @PostMapping("/bookingticket/createorder")
    public boolean addBookingRecord(@RequestParam("userId") Integer userId,
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

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.GET)
    public BookingRecord getBookingRecord(@RequestParam Integer id){
        return new TicketOrderBO().findOrderById(id);
    }

//    @RequestMapping(value = "/bookingrecord", method = RequestMethod.PUT)
//    public boolean updateBookingRecord(@RequestParam("id") Integer id,
//                                       @RequestParam(value = "status", defaultValue ="-1") Integer status){
//        // update booking record by id in database
//        return true;
//    }

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.DELETE)
    public boolean deleteBookingRecord(@RequestParam Integer id){
        return new TicketOrderBO().deleteOrder(id);
    }
}
