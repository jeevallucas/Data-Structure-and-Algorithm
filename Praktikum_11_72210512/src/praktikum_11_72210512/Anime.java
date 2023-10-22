package praktikum_11_72210512;

public class Anime {
    String code, animeTitle, type, rated, premiered, studios, genres;
    int score, episodes;

    public Anime(String code, String animeTitle, int score, String type, int episodes, String rated, String premiered, String studios, String genres) {
        this.code = code;
        this.animeTitle = animeTitle;
        this.score = score;
        this.type = type;
        this.episodes = episodes;
        this.rated = rated;
        this.premiered = premiered;
        this.studios = studios;
        this.genres = genres;
    }

    public String getRow() {
        return code + ", " + animeTitle + ", " + score + ", " + type + ", " + episodes + ", " + rated + ", " + premiered + ", " + studios + ", " + genres + "\n";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeTitle(String animeTitle) {
        this.animeTitle = animeTitle;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}