package RPC.com.fiap.abc.fase3.api.repository;

import RPC.com.fiap.abc.fase3.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
