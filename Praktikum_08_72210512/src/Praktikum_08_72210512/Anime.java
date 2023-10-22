package Praktikum_08_72210512;

public class Anime {
    private String kode;
    private String animeTitle;
    private int score;
    private String type;
    private int episodes;
    private String rated;
    private String premiered;
    private String studios;
    private String genres;

    public Anime(String kode, String animeTitle, int score, String type, int episodes, String rated, String premiered, String studios, String genres) {
        this.kode = kode;
        this.animeTitle = animeTitle;
        this.score = score;
        this.type = type;
        this.episodes = episodes;
        this.rated = rated;
        this.premiered = premiered;
        this.studios = studios;
        this.genres = genres;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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