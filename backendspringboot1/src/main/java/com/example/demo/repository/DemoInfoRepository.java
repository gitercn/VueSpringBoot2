package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.bean.DemoInfo;
public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long>{

}