async function LogInUser(username, password) {

  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  };
  return fetch("/user/login", requestOptions)
    .then((response) => response.json())
    .then((responseData) => {
      if (responseData === true) {
        return true;
      }
      return false;
    });
}

export { LogInUser };
