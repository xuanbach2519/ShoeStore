package bach.shoestore.Dto;

import bach.shoestore.Entity.Item;
import bach.shoestore.Entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseOrderDTO {
    private Integer codeOrder;
    public User user;
    public User staff;
    public Item item;
    private Integer quantity;
    private double money;
    private Integer process;
}
