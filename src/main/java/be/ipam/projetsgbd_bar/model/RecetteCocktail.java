package be.ipam.projetsgbd_bar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recette")
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecetteCocktail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_recette")
    private int idRecette;
    @Column(name = "nom_recette")
    private String nomRecette;
    @Column(name = "description_recette")
    private String descriptionRecette;
    @Column(name = "officielle")
    private Boolean officielle;
    //private List<Utilisateur> listUser = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "recettes", fetch = FetchType.LAZY)
    private Set<Utilisateur> utilisateur = new HashSet<>();

    public RecetteCocktail() {
    }

    public RecetteCocktail(int idRecette, String nomRecette, String descriptionRecette, Boolean officielle) {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
        this.descriptionRecette = descriptionRecette;
        this.officielle = officielle;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getDescriptionRecette() {
        return descriptionRecette;
    }

    public void setDescriptionRecette(String descriptionRecette) {
        this.descriptionRecette = descriptionRecette;
    }

    public Boolean getOfficielle() {
        return officielle;
    }

    public void setOfficielle(Boolean officielle) {
        this.officielle = officielle;
    }

    /*
    public List<Utilisateur> getListUser() {
        return listUser;
    }

    public void setListUser(List<Utilisateur> listUser) {
        this.listUser = listUser;
    }
     */

    public Set<Utilisateur> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Set<Utilisateur> utilisateur) {
        this.utilisateur = utilisateur;
    }

    /*
    @Override
    public String toString() {
        return "RecetteCocktail{" +
                "idRecette=" + idRecette +
                ", nomRecette='" + nomRecette + '\'' +
                ", descriptionRecette='" + descriptionRecette + '\'' +
                ", officielle=" + officielle +
                ", listUser=" + listUser +
                '}';
    }
     */

    @Override
    public String toString() {
        return "RecetteCocktail{" +
                "idRecette=" + idRecette +
                ", nomRecette='" + nomRecette + '\'' +
                ", descriptionRecette='" + descriptionRecette + '\'' +
                ", officielle=" + officielle +
                ", utilisateurs=" + utilisateur +
                '}';
    }
}
