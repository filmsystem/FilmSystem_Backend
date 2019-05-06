package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.BO.BookingRecordBO;
import shu.ces.filmsystem.Model.BookingRecord;

public class BookingRecordController {
    public static Logger log = LoggerFactory.getLogger(FilmShowController.class);

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.GET)
    public BookingRecord getBookingRecord(@RequestParam("id") Integer id){
        return new BookingRecordBO().findOrderById(id);
    }

//    @RequestMapping(value = "/bookingrecord", method = RequestMethod.PUT)
//    public boolean updateBookingRecord(@RequestParam("id") Integer id,
//                                       @RequestParam(value = "status", defaultValue ="-1") Integer status){
//        // update booking record by id in database
//        return true;
//    }

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.DELETE)
    public boolean deleteBookingRecord(@RequestParam("id") Integer id){
        return new BookingRecordBO().deleteOrder(id);
    }
}
