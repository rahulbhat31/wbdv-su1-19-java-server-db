package com.example.myapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Topic;

public interface TopicRepository  extends CrudRepository<Topic, Integer> {

}
