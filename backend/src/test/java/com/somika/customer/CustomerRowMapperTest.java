package com.somika.customer;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerRowMapperTest {

    @Test
    void mapRow() throws SQLException {

        CustomerRowMapper customerRowMapper = new CustomerRowMapper();
        ResultSet rs = mock(ResultSet.class);

        Customer customer = new Customer(
                10l,
                "Alex",
                "alex@gmail.com",
                22
        );

        when(rs.getLong("id")).thenReturn(customer.getId());
        when(rs.getString("name")).thenReturn(customer.getName());
        when(rs.getString("email")).thenReturn(customer.getEmail());
        when(rs.getInt("age")).thenReturn(customer.getAge());

        Customer actual = customerRowMapper.mapRow(rs, 1);

        assertThat(actual).isEqualTo(customer);
    }
}