package modelos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskHubTest {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("PU"); //Persistence Unit

        EntityManager EM = emf.createEntityManager();

        try {
            Usuario usario1 = new Usuario(1,
                                        "Muttley",
                                        "Muttley@gmail.com",
                                        "Muttley456");

            Usuario usuario2 = new Usuario(2,
                                        "Dick Vigarista",
                                        "Dick@gmail.com",
                                        "Dick123");

            //Persistir Usuários
            EM.getTransaction().begin();
            EM.persist(usario1);
            EM.persist(usuario2);
            EM.getTransaction().commit();

        }finally {
            EM.close();
            emf.close();
        }





    }
}
