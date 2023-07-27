async function RegisterUser(username, password) {
  
  return fetch("http://localhost:0420/user", {
  
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({username, password}),
  })
    .then((res) => res.json())

}
export {RegisterUser};