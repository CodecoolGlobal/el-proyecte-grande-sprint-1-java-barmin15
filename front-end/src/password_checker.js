const format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;

  export function isContainsSpecialCharacter(password) {
    return password.match(format) ? true : false;
  }

  export function isPasswordLongEnough(password) {
    return password.length >= 8 ? true : false;
  }

  export function isContainsNumber(password) {
    for (let i = 0; i < password.length; i++) {
      if (!isNaN(password[i])) return true;
    }
    return false;
  }

  export function isContainsCapitalLetter(password) {
    for (let i = 0; i < password.length; i++) {
      if (
        password[i] === password[i].toUpperCase() &&
        isNaN(password[i]) &&
        !format.toString().includes(password[i])
      ) {
        return true;
      }
    }
    return false;
  }