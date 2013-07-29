package com.springapp.mvc;
  import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created with IntelliJ IDEA.
 * User: kip
 * Date: 7/27/13
 * Time: 1:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Long>  {

}
