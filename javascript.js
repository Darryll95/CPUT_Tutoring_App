function formValidation() {
    var password = document.login.password;
    var phone = document.registration.phone;
    var email = document.registration.email;
    var password = document.registration.password;
    var email = document.password.email;

    function password(text)
    {
        var password = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
        if (text.value.match(password))
        {
            alert("Valid password!");
            return true;
        } else
        {
            alert("You have entered an invalid password!");
            return false;
        }
    }

    function encryptPassword()
    {
        var password = document.getElementById('password').value;
        var hidePassword = document.getElementById('hide').value;
        if (password == " ")
        {
            document.getElementById('err').innerHTML = 'Error: Password is missing';
            return false;
        } else
        {
            document.getElementById('hide').value = document.getElementById('password').value;
            var hash = CryptoJS.MD5(password);
            document.getElementById('password').value = hash;
            return true;
        }
    }

    function email(text)
    {
        var email = /^\w\w.+@mycput\.ac.za/;
        if (text.value.match(email))
        {
            alert("Valid email address!");
            return true;
        } else
        {
            alert("You have entered an invalid email address!");
            return false;
        }
    }

    function phone(text)
    {
        var phone = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
        if (text.value.match(phone))
        {
            return true;
        } else
        {
            alert("Not a valid Phone Number");
            return false;
        }
    }
}
