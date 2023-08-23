import { useState, useEffect } from "react";
import { getAuthToken, request } from "../../axios_helper";
import { useNavigate } from "react-router-dom";
function useAllCategories() {
  const navigate = useNavigate();
  const [categories, setCategories] = useState();
  
  useEffect(() => {
    request("GET",
      "/category",
      { "headers": { "Authorization": `Bearer ${getAuthToken()}` } }
    ).then((response) => {
      setCategories(response.data)
    }).catch((error) => {
      navigate("/login")
    })
  }, []);
  return categories;
}

export default useAllCategories;