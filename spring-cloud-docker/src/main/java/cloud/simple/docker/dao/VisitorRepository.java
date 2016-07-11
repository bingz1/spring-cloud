package cloud.simple.docker.dao;

import cloud.simple.docker.entiyt.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zxb on 7/8/16.
 */
public interface VisitorRepository extends MongoRepository<Visitor,String> {

}
