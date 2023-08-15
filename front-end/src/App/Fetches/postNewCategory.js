async function postNewCategory(category) {
  let name = category;
   fetch("/category", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name }),
  }).then((res) => res.json());
}

export { postNewCategory };
