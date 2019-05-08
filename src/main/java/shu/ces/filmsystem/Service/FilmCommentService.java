package shu.ces.filmsystem.Service;

import shu.ces.filmsystem.Model.FilmComment;

public class FilmCommentService {
    public boolean insertComment(FilmComment comment){
        // add to database
        return true;
    }

    public boolean deleteComment(int id){
        // delete in database
        return true;
    }

    public boolean updateComment(FilmComment comment){
        // update in database
        return true;
    }

    public FilmComment findFilmCommentById(int id){
        // find in database
        return null;
    }

    public FilmComment findFilmCommentByUserId(int userId){
        // find in database
        return null;
    }

    public FilmComment findFilmCommentByFilmId(int filmId){
        // find in database
        return null;
    }
}
