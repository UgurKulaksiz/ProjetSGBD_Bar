/*
package be.ipam.projetsgbd_bar.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import be.ipam.projetsgbd_bar.model.Utilisateur;
import be.ipam.projetsgbd_bar.service.UtilisateurService;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetails{
    private static final Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    UtilisateurService utilisateurService;


    @Transactional
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername "+username);
        Optional<JwtUserDetails> user = Optional.empty();

        //Ici normalement je récupère le user selon le paramètre login
        Optional<Utilisateur> utilisateur = utilisateurService.findByLogin(username);
        log.info("USER Found : " + utilisateur.get().getPrenomUser()+" "+utilisateur.get().getNomUser());

        if(utilisateur.isPresent()) {
            Utilisateur user1 = utilisateur.get();
            log.info("USER Found : " + user1.getIdUser());
            List<String> listRole = new ArrayList<String>();
            user1.getRoles().forEach(roles -> listRole.add("ROLE(S) de "+user1.getPrenomUser()+user1.getNomUser()+
                    ": "+roles.getRole().toUpperCase()));

            //Ici je crée un user spring sur base de mon Utilisateur
            user = Optional.of(new JwtUserDetails(user1.getEmail(),user1.getPassword(), listRole));

        }

        //if(pat.isPresent()) {
        //  user = Optional.of(new JwtUserDetails(pat.get().getId(),pat.get().getMail(),pat.get().getPw(),"ROLE_PATIENT"));
        //}

        //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        //  .filter(u -> u.getUsername().equals(username)).findFirst();


        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        //LOG
        log.info("My password is "+user.get().getPassword());

        return user.get();
    }

}

 */
