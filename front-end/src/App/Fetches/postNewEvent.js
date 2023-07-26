
function PostNewEvent(event) {
    return fetch("http://localhost:0420/event", {
    
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(event),
    })
      .then((res) => res.json());

}
export {PostNewEvent};