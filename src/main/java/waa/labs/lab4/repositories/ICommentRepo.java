package waa.labs.lab4.repositories;

import org.springframework.data.repository.CrudRepository;
import waa.labs.lab4.domains.Comment;

import java.util.List;

public interface ICommentRepo extends CrudRepository<Comment, Long> {
    @Override
    List<Comment> findAll();
}
