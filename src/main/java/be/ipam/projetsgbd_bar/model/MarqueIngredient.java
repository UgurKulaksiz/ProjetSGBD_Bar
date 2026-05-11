package be.ipam.projetsgbd_bar.model;

import java.util.ArrayList;
import java.util.List;

public class MarqueIngredient {
    private int idMarqueIngredient;
    private String marqueIngredient;
    private List<Ingredient> listIngredient = new ArrayList<>();

    public MarqueIngredient() {
    }

    public MarqueIngredient(int idMarqueIngredient, String marqueIngredient) {
        this.idMarqueIngredient = idMarqueIngredient;
        this.marqueIngredient = marqueIngredient;
    }

    public MarqueIngredient(int idMarqueIngredient, String marqueIngredient, List<Ingredient> listIngredient) {
        this.idMarqueIngredient = idMarqueIngredient;
        this.marqueIngredient = marqueIngredient;
        this.listIngredient = listIngredient;
    }

    public int getIdMarqueIngredient() {
        return idMarqueIngredient;
    }

    public void setIdMarqueIngredient(int idMarqueIngredient) {
        this.idMarqueIngredient = idMarqueIngredient;
    }

    public String getMarqueIngredient() {
        return marqueIngredient;
    }

    public void setMarqueIngredient(String marqueIngredient) {
        this.marqueIngredient = marqueIngredient;
    }

    public List<Ingredient> getListIngredient() {
        return listIngredient;
    }

    public void setListIngredient(List<Ingredient> listIngredient) {
        this.listIngredient = listIngredient;
    }

    @Override
    public String toString() {
        return "MarqueIngredient{" +
                "idMarqueIngredient=" + idMarqueIngredient +
                ", marqueIngredient='" + marqueIngredient + '\'' +
                ", listIngredient=" + listIngredient +
                '}';
    }
}
