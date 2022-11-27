package RPC.com.fiap.abc.fase3.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "operator_id", nullable = false)
    private Long operatorId;

    @ManyToMany
    private List<Assistance> assists;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "start order location id", foreignKey = @ForeignKey(name = "FK_start_order_id"))
    private OrderLocation startOrderLocation;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "end order location id" , foreignKey = @ForeignKey(name = "FK_end_order_id"))
    private OrderLocation endOrderLocation;


    public boolean hasMinAssists () {
        return assists.size() > 0;}

    public boolean execeedsMaxAssists () {return assists.size() > 15;}


}
