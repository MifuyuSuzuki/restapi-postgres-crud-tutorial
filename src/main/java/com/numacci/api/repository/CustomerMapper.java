package com.numacci.api.repository;

import com.numacci.api.dto.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    /**
     * Insert a new customer record to the database.
     *
     * @param customer customer object which we want to insert
     * @return the number of inserted records
     */
    int insert(Customer customer);
}
//このMapperをimplementsしたクラスは実装しない
// ・・・xmlファイルにSQLを記述することで、MyBatisがよしなに処理を実行してくれる
