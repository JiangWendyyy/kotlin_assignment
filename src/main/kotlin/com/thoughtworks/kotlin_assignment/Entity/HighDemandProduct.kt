package com.thoughtworks.kotlin_assignment.Entity

private const val ORIGINAL_PRICE_INVENTORY = 100
private const val PERCENT_30_UP_PRICE_INVENTORY = 30


class HighDemandProduct(
    override val id: Int,
    override val SKU: String,
    override val name: String,
    override var price: Double,
    override val type: String = "HIGH_DEMAND",
    override val image: String,
    override var inventories: List<Inventory> = emptyList()
) : Product(id,SKU, name, price, type,image) {
    override fun calculatePrice():Double{
        val inventory = this.getInventory()
        return when {
            inventory > ORIGINAL_PRICE_INVENTORY -> price
            inventory in (PERCENT_30_UP_PRICE_INVENTORY + 1)..ORIGINAL_PRICE_INVENTORY -> this.price * 1.2
            inventory <= PERCENT_30_UP_PRICE_INVENTORY -> price * 1.5
            else -> {
                price
            }
        }
    }

    fun setCalculatedPrice(price: Double){
        this.price = price
    }
}
