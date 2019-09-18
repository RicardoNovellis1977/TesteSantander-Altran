package com.ricardo.testesantander

import com.ricardo.testesantander.view.MainActivity
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var getUserCPF = "365.354.988-70"
    var getUSerEmail = "test_email@mail.com"
    var getPassword = "Abcd@1"

    var getUserCPFInvalid = "37692v5842"           // digito invalido
    var getUSerEmailInvalid = "test_emailmail.com"     // Email sem @
    var getPasswordInvalid = "Abcde1"                  // Senha sem caractere especial


    var loginControlValidationCPF  = MainActivity().isCpf(getUserCPF)
    var loginControlValidationEmail= MainActivity().isEmailValid(getUSerEmail)
    var loginControlValidationSenha= MainActivity().isSenhaForte(getPassword)


    var loginControlValidationCPFInvalid = MainActivity().isCpf(getUserCPFInvalid)
    var loginControlValidationEmailInvalid= MainActivity().isEmailValid(getUSerEmailInvalid)
    var loginControlValidationSenhaInvalid = MainActivity().isSenhaForte(getPasswordInvalid)


    @Test
    fun shouldValidateIfLoginIsValidCPF() {
        val isValid: Boolean = loginControlValidationCPF
        assertTrue(isValid)
    }

    @Test
    fun shouldValidateIfLoginIsValidEmail() {
        val isValid: Boolean = loginControlValidationEmail
        assertTrue(isValid)
    }
   @Test
    fun shouldValidateIfLoginIsValidSenha() {
        val isValid: Boolean = loginControlValidationSenha
        assertTrue(isValid)
    }

    @Test
    fun shouldValidateIfLoginIsInvalidCPF() {
        val isValid: Boolean = loginControlValidationCPFInvalid
        assertFalse(isValid)
    }

    @Test
    fun shouldValidateIfLoginIsInvalidEmail() {
        val isValid: Boolean = loginControlValidationEmailInvalid
        assertFalse(isValid)
    }

    @Test
    fun shouldValidateIfLoginIsInvalidSenha() {
        val isValid: Boolean = loginControlValidationSenhaInvalid
        assertFalse(isValid)
    }
}
