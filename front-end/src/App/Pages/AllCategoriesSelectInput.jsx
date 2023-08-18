import { useState } from "react";
import { postNewCategory } from "../Fetches/postNewCategory";

function AllCategoiresSelectInput(props) {
  const { categories, handleChange, chosenValue, vmi } = props;

  const [inputCategory, setInputCategory] = useState(null);
  const [newCategoryk, setNewCategoryk] = useState(0);

  async function handleSaveCategory(e) {
    e.preventDefault();
    await postNewCategory(inputCategory);

    setTimeout(() => {
      vmi();
    }, "500");

    setNewCategoryk(newCategoryk + 1);
  }

  console.log(categories);

  return (
    <div className="categories">
      <label htmlFor="categories">Choose a category:</label>
      <select
        onChange={handleChange}
        value={chosenValue}
        name="categories"
        id="categories"
      >
        {categories &&
          categories.map((e) => (
            <option value={e.id} key={e.id}>
              {e.name}
            </option>
          ))}
      </select>

      <div className="date">
        <label htmlFor="date">Or add a new one:</label>
        <div className="addCategory">
        <input
          type="text"
          /*placeholder={"new category..."}*/
          name="date"
          id="date"
          onChange={(e) => setInputCategory(e.target.value)}
        />
        <button
          onClick={(e) => {
            inputCategory && handleSaveCategory(e);
          }}
        >
          +
        </button>
          </div>
      </div>
    </div>
  );
}

export default AllCategoiresSelectInput;
