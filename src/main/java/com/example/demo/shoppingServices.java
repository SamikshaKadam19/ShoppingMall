package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
 class MallService {

    private final ShopRepository shopRepository;
    private final MallAdministratorRepository mallAdministratorRepository;
    private final ShopOwnerRepository shopOwnerRepository;

    public MallService(ShopRepository shopRepository, MallAdministratorRepository mallAdministratorRepository, ShopOwnerRepository shopOwnerRepository) {
        this.shopRepository = shopRepository;
        this.mallAdministratorRepository = mallAdministratorRepository;
        this.shopOwnerRepository = shopOwnerRepository;
    }

    public Shop createShop(String name, String description) {
        Shop newShop = new Shop();
        newShop.setName(name);
        newShop.setDescription(description);
        newShop.setOpen(true);
        return shopRepository.save(newShop);
    }

    public Shop closeShop(Long shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isPresent()) {
            shop.get().setOpen(false);
            return shopRepository.save(shop.get());
        }
        return null;
    }

    public ShopOwner createShopOwner(String name, Shop shop) {
        ShopOwner shopOwner = new ShopOwner();
        shopOwner.setName(name);
        shopOwner.setShop(shop);
        return shopOwnerRepository.save(shopOwner);
    }
}

