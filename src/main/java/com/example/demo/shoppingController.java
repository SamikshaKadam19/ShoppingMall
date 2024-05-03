package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
 class MallController {

    private final MallService mallService;

    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @PostMapping("/shops")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop newShop = mallService.createShop(shop.getName(), shop.getDescription());
        return ResponseEntity.ok(newShop);
    }

    @PostMapping("/shop-owners")
    public ResponseEntity<ShopOwner> createShopOwner(@RequestBody ShopOwner shopOwner) {
        Shop shop = mallService.createShop(shopOwner.getShop().getName(), shopOwner.getShop().getDescription());
        ShopOwner newShopOwner = mallService.createShopOwner(shopOwner.getName(), shop);
        return ResponseEntity.ok(newShopOwner);
    }

    @PostMapping("/shops/{id}/close")
    public ResponseEntity<Shop> closeShop(@PathVariable Long id) {
        Shop closedShop = mallService.closeShop(id);
        if (closedShop != null) {
            return ResponseEntity.ok(closedShop);
        }
        return ResponseEntity.notFound().build();
    }
}

