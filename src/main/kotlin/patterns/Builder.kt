package patterns

data class FoodOrder private constructor(
    val name: String?,
    val bread: String?,
    val meat: String?) {
    companion object {
        fun newBuilder(): FirstNameStep = Builder()
    }
    interface FirstNameStep {
        fun setName(name: String): BreadTypeStep
    }
    interface BreadTypeStep {
        fun setBread(name: String): MeatStep
    }
    interface MeatStep {
        fun setMeat(name: String): FinalStep
    }
    interface FinalStep {
        fun build(): FoodOrder
    }

    private data class Builder(
        var name: String? = null,
        var bread: String? = null,
        var meat: String? = null): FirstNameStep, BreadTypeStep, MeatStep, FinalStep
    {

        override fun setName(name: String): BreadTypeStep {
            this.name = name
            return this
        }

        override fun setBread(name: String): MeatStep {
            this.name = name
            return this
        }

        override fun setMeat(name: String): FinalStep {
            this.name = name
            return this
        }

        override fun build(): FoodOrder {
            return FoodOrder(name, bread, meat)
        }
    }
}

fun main() {
    val foodOrder = FoodOrder
        .newBuilder()
        .setName("name")
        .setBread("bread")
        .setMeat("turkey")
        .build()

}