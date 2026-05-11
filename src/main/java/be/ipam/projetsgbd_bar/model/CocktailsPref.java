package be.ipam.projetsgbd_bar.model;

import java.util.ArrayList;
import java.util.List;

public class CocktailsPref {
    private int idCockatailPref;
    private String nomCocktail;
    private int note;
    private String commentaire;
    private Boolean favori;
    private String memoPersonnel;

    private List<RecetteCocktail> listRecetteCocktail = new ArrayList<>();
    private List<Utilisateur> listUser = new ArrayList<>();

    public CocktailsPref() {
    }

    public CocktailsPref(int idCockatailPref, String nomCocktail, int note, String commentaire, Boolean favori, String memoPersonnel) {
        this.idCockatailPref = idCockatailPref;
        this.nomCocktail = nomCocktail;
        this.note = note;
        this.commentaire = commentaire;
        this.favori = favori;
        this.memoPersonnel = memoPersonnel;
    }

    public CocktailsPref(int idCockatailPref, String nomCocktail, int note, String commentaire, Boolean favori,
                         String memoPersonnel, List<RecetteCocktail> listRecetteCocktail, List<Utilisateur> listUser) {
        this.idCockatailPref = idCockatailPref;
        this.nomCocktail = nomCocktail;
        this.note = note;
        this.commentaire = commentaire;
        this.favori = favori;
        this.memoPersonnel = memoPersonnel;
        this.listRecetteCocktail = listRecetteCocktail;
        this.listUser = listUser;
    }

    public int getIdCockatailPref() {
        return idCockatailPref;
    }

    public void setIdCockatailPref(int idCockatailPref) {
        this.idCockatailPref = idCockatailPref;
    }

    public String getNomCocktail() {
        return nomCocktail;
    }

    public void setNomCocktail(String nomCocktail) {
        this.nomCocktail = nomCocktail;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boolean getFavori() {
        return favori;
    }

    public void setFavori(Boolean favori) {
        this.favori = favori;
    }

    public String getMemoPersonnel() {
        return memoPersonnel;
    }

    public void setMemoPersonnel(String memoPersonnel) {
        this.memoPersonnel = memoPersonnel;
    }

    public List<RecetteCocktail> getListRecetteCocktail() {
        return listRecetteCocktail;
    }

    public void setListRecetteCocktail(List<RecetteCocktail> listRecetteCocktail) {
        this.listRecetteCocktail = listRecetteCocktail;
    }

    public List<Utilisateur> getListUser() {
        return listUser;
    }

    public void setListUser(List<Utilisateur> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "CocktailsPref{" +
                "idCockatailPref=" + idCockatailPref +
                ", nomCocktail='" + nomCocktail + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", favori=" + favori +
                ", memoPersonnel='" + memoPersonnel + '\'' +
                ", listRecetteCocktail=" + listRecetteCocktail +
                ", listUser=" + listUser +
                '}';
    }
}
