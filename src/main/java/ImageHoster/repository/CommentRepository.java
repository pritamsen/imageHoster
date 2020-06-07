package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

  // Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  // In this method comment object to be persisted
  // transaction is committed if it is successful or rolled back
  public List<Comment> updateAComment(Comment newComment, Integer imageId) {

    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
      transaction.begin();
      em.persist(newComment);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    }

    List<Comment> comments = getListOfCommentsByImageId(imageId);
    comments.add(newComment);
    return comments;
  }

  // JPQL query to fetch all the comments
  // list of all the comments fetched
  public List<Comment> getListOfCommentsByImageId(Integer imageId) {
    EntityManager em = emf.createEntityManager();
    TypedQuery<Image> typedQuery =
        em.createQuery("SELECT i from Image i where i.id =:imageId", Image.class)
            .setParameter("imageId", imageId);
    Image image = typedQuery.getSingleResult();
    TypedQuery<Comment> query =
        em.createQuery("SELECT c from Comment c where c.image=:image ", Comment.class)
            .setParameter("image", image);
    List<Comment> resultList = query.getResultList();

    return resultList;
  }
}
