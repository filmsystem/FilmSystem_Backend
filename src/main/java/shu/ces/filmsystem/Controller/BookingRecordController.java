package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.Model.BookingRecord;

import java.sql.Timestamp;

public class BookingRecordController {
    public static Logger log = LoggerFactory.getLogger(FilmShowController.class);

    @PostMapping("/bookingrecord")
//    public boolean addBookingRecord(@RequestParam("filmId") Integer filmId, @RequestParam("cinemaId") Integer cinemaId, @RequestParam("officeId") Integer officeId,
//                                    @RequestParam("beginTime") Timestamp beginTime, @RequestParam("duration") Integer duration, @RequestParam("price") double price){
//        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
//        try{
//            // add to database
//            return true;
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.GET)
    public BookingRecord getBookingRecord(@RequestParam Integer id){
        // find booking record by id in database
        return null;
    }

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.PUT)
    public boolean updateBookingRecord(@RequestParam("id") Integer id, @RequestParam(value = "status", defaultValue ="-1") Integer status){
        // update booking record by id in database
        return true;
    }

    @RequestMapping(value = "/bookingrecord", method = RequestMethod.DELETE)
    public boolean deleteBookingRecord(@RequestParam Integer id){
        // delete booking record by id in database
        return true;
    }
}
