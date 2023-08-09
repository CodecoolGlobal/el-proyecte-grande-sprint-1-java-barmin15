function updateEvent(event) {
    return fetch("/event", {
    
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(event),
    })
      .then((res) => res.json());

}
export {updateEvent};