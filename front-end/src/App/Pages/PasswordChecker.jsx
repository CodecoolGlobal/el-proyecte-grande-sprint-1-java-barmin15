import {
  isContainsSpecialCharacter,
  isContainsNumber,
  isContainsCapitalLetter,
  isPasswordLongEnough
} from "../../password_checker";

const PasswordChecker = ({password}) => {

  const capitalLetter = <li>must include a capital letter</li>;
  const numberCharacter = <li>must include a number character</li>;
  const specialCharacter = <li>must include a special character</li>;
  const passwordLength = <li>must be 8 digits or longer</li>;

  return (
    <div>
      <ul style={{ listStyleType: "none" }}>
        {!isContainsCapitalLetter(password) && capitalLetter}
        {!isContainsNumber(password) && numberCharacter}
        {!isContainsSpecialCharacter(password) && specialCharacter}
        {!isPasswordLongEnough(password) && passwordLength}
      </ul>
    </div>
  );
};

export default PasswordChecker;
