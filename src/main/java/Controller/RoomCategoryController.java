package Controller;

import Model_Entitiy.RoomCategoryEntity;
import Service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-categories")
public class RoomCategoryController {
    @Autowired
    private RoomCategoryService roomCategoryService;

    @GetMapping
    public List<RoomCategoryEntity> getAllRoomCategories() {
        return roomCategoryService.getAllRoomCategories();
    }

    @PostMapping
    public void addRoomCategory(@RequestBody RoomCategoryEntity roomCategoryEntity) {
        roomCategoryService.addRoomCategory(roomCategoryEntity);
    }

    // Other endpoints as needed
}
