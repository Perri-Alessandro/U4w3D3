package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDao;
import org.example.dao.PersonaDao;
import org.example.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("U4w3D3");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManager em = emFactory.createEntityManager();
        EventoDAO eventoDao = new EventoDAO(em);
        LocationDAO locatDao = new LocationDAO(em);
        PersonaDao personaDAO = new PersonaDao(em);
        PartecipazioneDao partDAO = new PartecipazioneDao(em);


        Location roma = new Location("giornata sugli sci", "Passo san Pellegrino");

        locatDao.save(roma);

        Partecipazione eccomi = null;
        Evento test = new Evento("gita in montagna"
                , LocalDate.of(2024, 4, 12)
                , "fewrzgrehrth", 20, EventoType.PRIVATO, (List<Partecipazione>) eccomi, roma);

        System.out.println("Hello World!");

        eventoDao.save(test);


        Persona prima = new Persona("Giorgio", "Bianchi", "giorgiobianchi@gmail.com", LocalDate.of(1993, 9, 6), PersonaType.M, (List<Partecipazione>) eccomi);
        personaDAO.save(prima);

        eccomi = new Partecipazione(prima, test);

        partDAO.save(eccomi);


//        Evento trova = null;
//        try {
//            System.out.println("----------------------- INSERISCI 1 ID PER CERCARE 1 EVENTO NEL DATABASE ----------------------------");
//            int id = Integer.parseInt(sc.nextLine());
//            trova = eventoDao.getById(id);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println(trova.getTitolo());
//        }

//        Evento cancella = null;
//        try {
//            System.out.println("------------------------------ INSERISCI L'ID DI ELEMENTO DA ELIMINARE ----------------------------------");
//            int id = Integer.parseInt(sc.nextLine());
//            eventoDao.delete(id);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println(cancella.getTitolo());
//        }


        em.close();
        emFactory.close();
        sc.close();
    }
}
