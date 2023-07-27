export function LogInUser(username, password) {
        return fetch("http://localhost:0420/login", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({username, password}),
        })
          .then((res) => res.json());
}
