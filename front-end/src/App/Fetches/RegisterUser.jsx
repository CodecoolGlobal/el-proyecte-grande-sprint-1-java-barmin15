async function RegisterUser(username, password) {

  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password })
};
 return fetch('http://localhost:0420/user', requestOptions)
    .then(response => response.json())
    .then((responseData) => {
      return responseData;
    })

}


export { RegisterUser };