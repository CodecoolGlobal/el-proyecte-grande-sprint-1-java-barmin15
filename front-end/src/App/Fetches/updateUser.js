function updateUser(user) {
    return fetch("/user", {
    
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((res) => res.json());

}
export {updateUser};