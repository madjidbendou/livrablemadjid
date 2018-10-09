package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Player;

public class MemoryDaoImpl implements MemoryDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("team");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	@Override
	public Player findById(int id) {
		try {
			tx.begin();
			Player player = em.find(Player.class, id);
			System.out.println(player);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {

				emf.close();
			}
		}
		return null;
	}

	@Override
	public void create(Player player) {
		try {
			tx.begin();
			
			em.persist(player);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {

				emf.close();
			}
		}
	}

	@Override
	public void update(int id, String name) {
		try {
			tx.begin();
			Player player = em.find(Player.class, id);
			player.setName(name);
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			} e.printStackTrace();
		}finally {
			if (em != null) {
				em.close();
			} if (emf !=null) {
				
			emf.close();
			}
		}
	}

	@Override
	public void delete(int id) {
		try {
			tx.begin();
			Player player = em.find(Player.class, id);
			em.remove(player);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {

				emf.close();
			}
		}
	}

}
