package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

 interface ShopRepository extends JpaRepository<Shop, Long> {}

 interface MallAdministratorRepository extends JpaRepository<MallAdministrator, Long> {}

 interface ShopOwnerRepository extends JpaRepository<ShopOwner, Long> {}

 interface MallCustomerRepository extends JpaRepository<MallCustomer, Long> {}
