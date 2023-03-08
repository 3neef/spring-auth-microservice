package com.microservices.micro.services;

import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.micro.models.Item;
import com.microservices.micro.models.Order;
import com.microservices.micro.models.User;
import com.microservices.micro.repos.ItemRepository;
import com.microservices.micro.repos.OrderRepository;
import com.microservices.micro.repos.UserRepository;
import com.microservices.micro.requests.CreateItemRequest;
import com.microservices.micro.requests.CreateOrderRequest;
import com.microservices.micro.requests.UserRequest;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public Order create(CreateOrderRequest orderRequest) {
        User user = createUser(orderRequest.getUser());
        System.out.println("here is the user " + user);
        Order order = new Order();
        order.setAmount(orderRequest.getAmount());
        order.setUserId(user.getId());
        order.setUser(user);
        order.setStatus(orderRequest.getStatus());
        orderRepository.save(order);
       
        try {
            createItem(orderRequest.getItem());
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return order;
    }

    private User createUser(UserRequest user) {
        User dbUser = new User(0, user.getName(), user.getPassword(), null,null,null);

        User result = userRepository.save(dbUser);

        return result;

    }

    @Transactional(rollbackFor = SQLException.class)
    private void createItem(CreateItemRequest item) throws SQLException {
        itemRepository.save(Item.build(1, item.getName(), item.getPrice()));

        throw new SQLException("user thrown exception");
    }
}
