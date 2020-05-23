let email_input = document.querySelector(".email-input");
const passw_input = document.querySelector(".passw-input");
const warning_paragraph = document.querySelector(".warning");
let second_passw_input = document.querySelector(".sec-passw");
let resetPasswBtn = document.querySelector(".button");

const submitBtn = document.querySelector(".submit-button");

function emailValidator() {
    var mailformat = /([a-zA-z_\-.\]+)@([a-zA-z0-9-]+)\.([a-z\.])/
    let email_value = email_input.value;
    let validEmail = mailformat.test(email_value);
    displayWarning(validEmail);
}
function passwordValidator() {
    var passwFormat = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    let passw_value = passw_input.value;
    let validPassw = passwFormat.test(passw_value);
    displayWarning(validPassw);
}

function checkMatchPasswords(){
    let passw_value = passw_input.value;
    let sec_passw = document.querySelector(".sec-passw").value;
    const warnig_passw_message = document.querySelector(".warning-passw");
    if(passw_value !== sec_passw){
        warnig_passw_message.classList.remove("hidden");
    }else{
        warnig_passw_message.classList.add("hidden")
    }
}

function displayWarning(validatorResult){
    if (validatorResult == false) {
        warning_paragraph.classList.remove("hidden");
    } else {
        warning_paragraph.classList.add("hidden");
    }
}

function checkIfPasswordsAreEquals(){
    resetPasswBtn.addEventListener("mouseover",checkMatchPasswords);
}

function checkPasswordForRegEx(){
    passw_input.addEventListener("focusout",passwordValidator);
}

function passwordClick() {
    passw_input.addEventListener("click", emailValidator);
}

function clickBtnResetPassw() {
    submitBtn.addEventListener("mouseover", emailValidator);
}