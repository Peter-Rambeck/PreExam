package facades;

import dtos.LoanDTO;
import dtos.RenameMeDTO;
import entities.Loan;
import entities.renameme.RenameMe;
import entities.renameme.RenameMeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class LoanFacade {

    private static LoanFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private LoanFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static LoanFacade getFacadeLoan(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LoanFacade();
        }
        return instance;
    }

    //TODO Remove/Change this before use
//    public long getRenameMeCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{  
//            em.close();
//        }
//        
//    }

//    @Override
//    public RenameMeDTO getById(int id) throws WebApplicationException {
//        EntityManager em = emf.createEntityManager();
//        RenameMe renameMe = em.find(RenameMe.class, id);
//        return new RenameMeDTO(renameMe);
//    }
//
//    @Override
//    public List<RenameMeDTO> getAll() throws WebApplicationException {
//        EntityManager em = emf.createEntityManager();
//        List<RenameMe> renameMes = em.createQuery("SELECT r FROM RenameMe r", RenameMe.class).getResultList();
//        return RenameMeDTO.getDtos(renameMes);
//    }

    //@Override
    public LoanDTO createLoan(LoanDTO loanDTO) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        Loan loan = new Loan(loanDTO.getCheckoutDate(), loanDTO.getDueDate(), loanDTO.getReturnedDate());
        try {
            em.getTransaction().begin();
            em.persist(loan);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new LoanDTO(loan);
    }
}
