package be.ipam.projetsgbd_bar.model;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private int idIngredient;
    private String nomIngredient;
    private String unite;

    private List<RecetteCocktail> listRecetteCocktail = new ArrayList<>();
    private List<Utilisateur> listUser = new ArrayList<>();


    public Ingredient() {
    }

    public Ingredient(int idIngredient, String nomIngredient, String unite) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.unite = unite;
    }

    public Ingredient(int idIngredient, String nomIngredient, String unite, List<RecetteCocktail> listRecetteCocktail, List<Utilisateur> listUser) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.unite = unite;
        this.listRecetteCocktail = listRecetteCocktail;
        this.listUser = listUser;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
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
        return "Ingredient{" +
                "idIngredient=" + idIngredient +
                ", nomIngredient='" + nomIngredient + '\'' +
                ", unite='" + unite + '\'' +
                ", listRecetteCocktail=" + listRecetteCocktail +
                ", listUser=" + listUser +
                '}';
    }
}
