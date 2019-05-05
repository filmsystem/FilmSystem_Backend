package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.FilmComment;

public class FilmCommentBO {
    public boolean addComment(FilmComment comment){
        // add to database
        return true;
    }

    public boolean deleteComment(int id){
        // delete in database
        return true;
    }

    public boolean updateComment(int id, int star, String comment){
        // update in database
        return true;
    }
}
