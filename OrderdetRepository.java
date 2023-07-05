package storePackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdetRepository extends JpaRepository<Order_Details,Long>{

}
