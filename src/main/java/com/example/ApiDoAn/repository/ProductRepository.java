package com.example.ApiDoAn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.ApiDoAn.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>, JpaSpecificationExecutor, PagingAndSortingRepository<ProductEntity, Long>  {
        Optional<ProductEntity> findById(Long id);
        Page<ProductEntity> findAll(Pageable pageable);
        @Query("SELECT u FROM ProductEntity  u  WHERE u.categoryEntity.id IN (:lstCateGoryID) and u.name LIKE %:keyword% ")
        Page <ProductEntity>  filterProduct(
          @Param("lstCateGoryID")List<Long> lstCateGory,
          @Param("keyword") String  keyword,
          Pageable pageable);
}
