package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class GetAllTheInventoryItemsUseCase (
    var inventoryRepository: InventoryRepository
) {

    fun getAllInventoryItems(): List<Inventory> {

        val allInventoryItems = inventoryRepository.findAll().toList()

        return allInventoryItems
    }

}