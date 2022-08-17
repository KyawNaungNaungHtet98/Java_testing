package mmit.z2p.service;

import java.util.List;

import javax.persistence.EntityManager;

import mmit.z2p.model.entity.Batch;


public class BatchSerive {
	private EntityManager em;
	public BatchSerive(EntityManager em) {
		this.em = em;
	}
	public List<Batch> findAll() {
		
		return em.createNamedQuery("getAllBatch",Batch.class).getResultList();
	}
	public Batch findById(int id) {
		
		return em.find(Batch.class, id);
	}
	public void save(Batch batch) {
		em.getTransaction().begin();
		if(batch.getId() == 0)
			em.persist(batch);
		else
			em.merge(batch);
		em.getTransaction().commit();
		
	}
	public List<Batch> findByLevelId(int lvl_id) {
		
		return em.createNamedQuery("getBatchByLevelId",Batch.class).setParameter("levelId", lvl_id).getResultList();
	}
}
