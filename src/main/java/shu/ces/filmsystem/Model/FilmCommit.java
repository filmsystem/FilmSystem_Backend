package shu.ces.filmsystem.Model;

public class FilmCommit {
    private int id;
    private int userId;
    private int filmId;
    private int filmStar;
    private int cinemaStar;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getFilmStar() {
        return filmStar;
    }

    public void setFilmStar(int filmStar) {
        this.filmStar = filmStar;
    }

    public int getCinemaStar() {
        return cinemaStar;
    }

    public void setCinemaStar(int cinemaStar) {
        this.cinemaStar = cinemaStar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
