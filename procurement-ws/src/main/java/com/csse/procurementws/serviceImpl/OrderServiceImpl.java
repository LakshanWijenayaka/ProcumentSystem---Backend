package com.csse.procurementws.serviceImpl;

import com.csse.procurementws.model.Item;
import com.csse.procurementws.model.Order;
import com.csse.procurementws.model.OrderItem;
import com.csse.procurementws.model.Supplier;
import com.csse.procurementws.repository.OrderItemRepository;
import com.csse.procurementws.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
@Service
public class OrderServiceImpl {
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderItemRepository orderItemRepository;
    
    @Autowired
    ItemServiceImpl itemServiceImpl;
    
    @Autowired
    SupplierServiceImpl supplierServiceImpl;
    
    public List<Order> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<Order> newOrderList = new ArrayList<>();
        for(Order order : orderList){
            //get respective OrderItem list
            List<OrderItem> orderItemList = orderItemRepository.getOrderItemsByOrderId(order.getId());
            
            //get item id list to integer list
            List<Integer> idList = new ArrayList<>();
            for(OrderItem orderItem : orderItemList){
                Integer itemId = orderItem.getItemId();
                idList.add(itemId);
            }
            //get item object list using id list
            List<Item> itemList = itemServiceImpl.getItemsByIdList(idList);
            List<Item> newItemList = new ArrayList<>();
            for(Item item : itemList){
                Supplier supplier = supplierServiceImpl.getSupplierById(item.getSupplier());
                item.setSupplierName(supplier.getsName());
                newItemList.add(item);
            }   
            order.setItemList(newItemList);
            newOrderList.add(order);
        }
        return newOrderList;
    }
    
    public void setStatusOrder(Integer id,String status){
        orderRepository.setStatusOrder(status , id);
    }
    
    public Order getOrderById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
