package com.ryanaubrey.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualDIConfig {

    public class Item {
        private final String id;

        public Item(String id) {
            this.id = id;
        }

        public String getItem() {
            return this.id;
        }
    }

    public class Store {
        private List<Item> items;

        public Store(List<Item> items) {
            this.items = items;
        }

        public List<Item> getItems() {
            return this.items;
        }
    }

    @Bean
    public Item item() {
        return new Item("123");
    }

    @Bean
    public Store store() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("123"));
        items.add(new Item("456"));
        return new Store(items);
    }
}
