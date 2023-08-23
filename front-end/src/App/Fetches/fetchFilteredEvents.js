import { useState, useEffect } from "react";
function useAllFilteredEvents(max, searchInput, selectedCategory, counter) {
  const [fetchedItems, setFetchedItems] = useState();
  useEffect(() => {
    const dataFetch = async () => {
        const limit = max;
        let byName = searchInput;
        let byCategories= selectedCategory;
        if(selectedCategory.length < 1) byCategories = "all";
        if(searchInput.length < 1) byName = "all";
        fetch(`/event/${byCategories}/${byName}/${limit * counter}`)
          .then((response) => response.json())
          .then((data) => {
          setFetchedItems(data)
          });
        }
        dataFetch();
  }, []);
  return fetchedItems;
}

export default useAllFilteredEvents;