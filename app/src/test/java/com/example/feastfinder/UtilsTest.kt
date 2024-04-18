import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test



object Patterns {
    private const val EMAIL_REGEX = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}"

    fun isValidEmail(email: String): Boolean {
        return Regex(EMAIL_REGEX).matches(email)
    }
}


class UtilsTest {

    @Test
    fun testIsValidEmail() {
        assertTrue(isValidEmail("test@example.com"))
        assertFalse(isValidEmail("invalid-email"))
    }

    @Test
    fun testIsValidPassword() {
        assertTrue(isValidPassword("password123"))
        assertFalse(isValidPassword("pass"))
    }

    @Test
    fun testIsValidLogin() {
        assertTrue(isValidLogin("test@example.com", "password123"))
        assertFalse(isValidLogin("invalid-email", "password123"))
        assertFalse(isValidLogin("test@example.com", "pass"))
        assertFalse(isValidLogin("invalid-email", "pass"))
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.isValidEmail(email)
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length > 6
    }

    private fun isValidLogin(email: String, password: String): Boolean {
        return isValidEmail(email) && isValidPassword(password)
    }
}
