package patterns

interface Virus {
    fun mutate()
    fun spread() {
        println("Spreading the virus...")
    }
}

class CoronaVirus: Virus {
    override fun mutate() {
        println("Mutating the corona virus...")
    }
}

class InfluenzaVirus: Virus {
    override fun mutate() {
        println("Mutating the flu virus...")
    }
}

class HIVVirus: Virus {
    override fun mutate() {
        println("Mutating the HIV virus...")
    }
}

class VirusFactory {
    fun makeVirus(type: VirusType): Virus {
        return when(type) {
            VirusType.CoronaVirus -> CoronaVirus()
            VirusType.Influenza -> InfluenzaVirus()
            VirusType.HIV -> HIVVirus()
        }
    }
}


sealed class VirusType {
    object CoronaVirus : VirusType()
    object Influenza : VirusType()
    object HIV : VirusType()
}


fun main() {
    val factory = VirusFactory()
    val virus = factory.makeVirus(VirusType.CoronaVirus)
    virus.spread()
    virus.mutate()
}