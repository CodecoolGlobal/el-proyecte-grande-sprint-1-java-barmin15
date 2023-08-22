import { useState, useEffect } from "react";
function useAllCategories() {
  const [categories, setCategories] = useState();

  useEffect(() => {
    const dataFetch = async () => {
      const data = await (await fetch("/category")).json();
      setCategories(data);
    };

    dataFetch();
  }, []);
  return categories;
}

export default useAllCategories;