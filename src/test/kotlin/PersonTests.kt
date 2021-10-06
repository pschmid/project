import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTests {
    @Test
    fun `Check person is created`() {
        val fullName = "Pablo Hernan Schmid"
        val name = "Pablo Schmid"
        Person(name).apply {
            assertThat(this.name).isEqualTo(name)
            this.name = fullName
            assertThat(this.name).isEqualTo(fullName)
        }

    }

}