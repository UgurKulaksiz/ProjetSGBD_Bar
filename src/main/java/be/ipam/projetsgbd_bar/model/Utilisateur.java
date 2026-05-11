package be.ipam.projetsgbd_bar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "utilisateur")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "nom_user")
    private String nom_user;
    @Column(name = "prenom_user")
    private String prenom_user;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    //Default Fetch is Lazy
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "UtilisateurRoles",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    //@Transient
    private Set<Roles> roles = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "UtilisateurRecette",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRecette")
    )
    private Set<RecetteCocktail> recettes = new HashSet<>();


    public Utilisateur(int idUser, String nom_user, String prenom_user, String email, String password) {
        this.idUser = idUser;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<RecetteCocktail> getRecettes() {
        return recettes;
    }

    public void setRecettes(Set<RecetteCocktail> recettes) {
        this.recettes = recettes;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUser=" + idUser +
                ", nom_user='" + nom_user + '\'' +
                ", prenom_user='" + prenom_user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    /*
    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUser=" + idUser +
                ", nom_user='" + nom_user + '\'' +
                ", prenom_user='" + prenom_user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", recettes=" + recettes +

               '}';
    }
     */
}
