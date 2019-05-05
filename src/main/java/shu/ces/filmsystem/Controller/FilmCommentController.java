package shu.ces.filmsystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shu.ces.filmsystem.BO.FilmCommentBO;
import shu.ces.filmsystem.Model.FilmComment;

public class FilmCommentController {
    public static Logger log = LoggerFactory.getLogger(FilmOfficeController.class);

    @PostMapping("/filmcomment")
    public boolean addFilmComment(@RequestParam("userId") Integer userId,
                                  @RequestParam("filmId") Integer filmId,
                                  @RequestParam("filmStar") Integer filmStar,
                                  @RequestParam("comment") String comment){
        // log.info("cinemaId = " + cinemaId + ", officeId = " + officeId + ", row = " + row + ", col = " + col);
        try{
            FilmComment Comment = new FilmComment();
            Comment.setUserId(userId);
            Comment.setFilmId(filmId);
            Comment.setFilmStar(filmStar);
            Comment.setComment(comment);
            return new FilmCommentBO().insertComment(Comment);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/filmcomment", method = RequestMethod.GET)
    public FilmComment getFilmComment(@RequestParam Integer id){
        return new FilmCommentBO().findFilmCommentById(id);
    }

    @RequestMapping(value = "/filmcomment", method = RequestMethod.PUT)
    public boolean updateFilmComment(@RequestParam("id") Integer id,
                                     @RequestParam("filmStar") Integer filmStar,
                                     @RequestParam("comment") String comment){
        FilmCommentBO commentBO = new FilmCommentBO();
        FilmComment Comment = commentBO.findFilmCommentById(id);
        if(comment == null){
            return false;
        }
        Comment.setFilmStar(filmStar);
        Comment.setComment(comment);
        return commentBO.updateComment(Comment);
    }

    @RequestMapping(value = "/filmcomment", method = RequestMethod.DELETE)
    public boolean deleteFilmComment(@RequestParam Integer id){
        return new FilmCommentBO().deleteComment(id);
    }
}
