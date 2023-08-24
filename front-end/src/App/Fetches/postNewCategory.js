import { request } from "../../axios_helper";

async function postNewCategory(category) {
  let name = category;
   return request("POST", "/category", category).then((res) => res.json());
}

export { postNewCategory };
