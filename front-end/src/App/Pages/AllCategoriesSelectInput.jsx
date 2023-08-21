import { useState } from "react";
import { postNewCategory } from "../Fetches/postNewCategory";

function AllCategoiresSelectInput(props) {
  const { categories, handleChange, chosenValue, onCreateCategory } = props;

  const [inputCategory, setInputCategory] = useState(null);

  async function handleSaveCategory(e) {
    e.preventDefault();
    await postNewCategory(inputCategory);

    onCreateCategory();
  }

  return (
    <div className="categories">
      <label htmlFor="categories">Choose an event category:</label>
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
        <label htmlFor="date">Or add a new category:</label>
        <input
          type="text"
          placeholder={"new category..."}
          name="date"
          id="date"
          onChange={(e) => setInputCategory(e.target.value)}
        />
        <button
          onClick={(e) => {
            inputCategory && handleSaveCategory(e);
          }}
        >
          add
        </button>
      </div>
    </div>
  );
}

export default AllCategoiresSelectInput;
