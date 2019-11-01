package app.repository;

import app.domain.entities.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl implements JobApplicationRepository {

    private final EntityManager entityManager;

    @Inject
    public JobApplicationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(JobApplication jobApplication) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(jobApplication);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<JobApplication> findAll() {
        return this.entityManager
                .createQuery("SELECT j FROM JobApplication j", JobApplication.class)
                .getResultList();
    }

    @Override
    public JobApplication findById(String id) {
        return entityManager.createQuery(
                "SELECT j FROM JobApplication j WHERE j.id = :id", JobApplication.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("DELETE FROM JobApplication j WHERE j.id =:id")
                .setParameter("id", id)
                .executeUpdate();

        this.entityManager.getTransaction().commit();
    }
}
